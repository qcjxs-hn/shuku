package com.shuku.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuku.entity.Book;
import com.shuku.entity.User;
import com.shuku.helper.BookHelper;
import com.shuku.helper.UserHelper;
import com.shuku.service.BookService;
import com.shuku.service.UserService;
import com.shuku.util.PropertyConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static com.shuku.common.Timeconversion.timeconversion;

@Controller
public class UploadController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;


    private static final Log logger = LogFactory.getLog(UploadController.class);

    @RequestMapping(value = "getUploadPage")
    public String getUploadPage(@RequestParam("userList") String userListJson, HttpSession session) {
        UserHelper userhelper = (UserHelper) session.getAttribute("userHelper");
        System.out.println(userListJson);
        // 使用 Jackson ObjectMapper 将 JSON 字符串转换为 Java 对象
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            UserHelper[] userArray = objectMapper.readValue(userListJson, UserHelper[].class);
            UserHelper userHelper=userArray[0];
            System.out.println(userHelper.getId());
            session.setAttribute("userHelper",userHelper);
            if (null == userArray) {
                return "redirect:index";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("you are visiting uploading page!");
        return "upload.jsp?userList="+userListJson;

    }
    @RequestMapping(value = "getUploadPagean")
    public String getUploadPagean(@RequestBody UserHelper userhelper,HttpSession session) {
        System.out.println(userhelper.getId());
        session.setAttribute("userHelper",userhelper);
//        UserHelper userHelper = (UserHelper) session.getAttribute("userHelper");
        // 使用 Jackson ObjectMapper 将 JSON 字符串转换为 Java 对象
        UserHelper userHelper = (UserHelper) session.getAttribute("userHelper");
            if (null == userHelper) {
                return "redirect:index";
            }
        logger.info("you are visiting uploading page!");
        return "upload";

//        return "";
    }

    @RequestMapping(value = "doUpload", method = RequestMethod.POST)
    public String doUpload(@ModelAttribute BookHelper bookHelper, Model model, HttpSession session) throws IllegalStateException, IOException, ParseException {
        logger.info("you are uploading a book! ");
        logger.info("This book is " + bookHelper.getTitle() + "!");
        String fileName = bookHelper.getBookFile().getOriginalFilename();
        String json="";
        String bookCover = bookHelper.getBookCover().getOriginalFilename();
        MultipartFile bookFile = bookHelper.getBookFile();
        MultipartFile coverFile = bookHelper.getBookCover();
        UserHelper userHelper = (UserHelper) session.getAttribute("userHelper");
        String userListJson=bookHelper.getUserList();
//        System.out.println(userHelper.getId());
        System.out.println(userListJson);
        model.addAttribute("userList",userListJson);
        if (bookFile.isEmpty()) {
            logger.info("Uploading failed! The book you are uploading is empty!");
            return "upload_failed";
        } else if (coverFile.isEmpty()) {
            logger.info("Uploading failed! The book cover you are uploading is empty!");
            return "upload_failed";
        } else {
            String typeId = "" + bookHelper.getLargeType() + bookHelper.getSmallType();
            int type_id = Integer.parseInt(typeId);
            String format = fileName.substring(fileName.lastIndexOf('.') + 1);
            List<String> typeNames;
            logger.info(type_id);
            typeNames = bookService.getTypeNames(type_id);
            String filePath_pre = (String) PropertyConfigurer.getProperty("book_path");
            String filePath = filePath_pre + typeNames.get(0) +
                    "/" + typeNames.get(1) + "/" +
                    bookHelper.getTitle() + "." + format;
            File localBookFile = new File(filePath);
            if (localBookFile.exists()) {
                logger.info("Uploading failed! The book is existed!");
                return "upload_failed2";
            }
            bookFile.transferTo(localBookFile);
            String coverPath_pre = (String) PropertyConfigurer.getProperty("book_cover_path");
            String coverPath = coverPath_pre + typeNames.get(0) +
                    "/" + typeNames.get(1) + "/" +
                    bookHelper.getTitle() + ".jpg";
            File localCoverFile = new File(coverPath);
            coverFile.transferTo(localCoverFile);
            logger.info("The book has uploaded to local path successfully!");
            Book book = new Book();
            book.setBooktitle(bookHelper.getTitle());
            book.setBookauthor(bookHelper.getAuthor());
            System.out.println(bookHelper.getPubYear());
            book.setBookpubyear(bookHelper.getPubYear());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            Date date = dateFormat.parse(bookHelper.getPubYear());
            book.setBooksummary(bookHelper.getSummary());
            book.setTypeid(type_id);
            book.setBookformat(format);
            book.setDownloadtimes(0);
            book.setBookfile(filePath);
            book.setBookcover(coverPath);
            dateFormat = new SimpleDateFormat("yyMMdd", Locale.CHINESE);
            String pubDate = dateFormat.format(date);
            String upDate = dateFormat.format(new Date());
            int random = new Random().nextInt(900) + 100;
            String idStr = "" + typeId + pubDate + upDate + random;
            long bookID = Long.parseLong(idStr);
            logger.info("The book id you uploaded is " + bookID);
            book.setId(bookID);
            bookService.uploadBook(book);
            bookService.updateRecords(userHelper.getId(), bookID);
            userService.updateUserContribution(2, userHelper.getId());
            model.addAttribute("userList",userHelper);
            model.addAttribute("bookID", bookID);
            logger.info("you are coming to the uploading successful page!");
            return "upload_success";
        }
    }
}