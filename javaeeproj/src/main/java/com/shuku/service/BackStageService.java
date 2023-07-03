package com.shuku.service;

import com.shuku.dao.BookDao;
import com.shuku.dao.FeedbackDao;
import com.shuku.dao.UploadDao;
import com.shuku.dao.UserDao;
import com.shuku.entity.Book;
import com.shuku.entity.Feedback;
import com.shuku.entity.Upload;
import com.shuku.entity.User;
import com.shuku.helper.doBookHelper;
import com.shuku.util.PropertyConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class BackStageService {
    @Autowired
    private UploadDao uploadDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private FeedbackDao feedbackDao;

    public boolean getLogin(String username, String password) {
        String default_user = (String) PropertyConfigurer.getProperty("admin_user");
        String default_pass = (String) PropertyConfigurer.getProperty("admin_password");
        if (default_user.equals(username) && default_pass.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public List<doBookHelper> iteratorUploadList(List<Upload> uploadList) {
        List<doBookHelper> doBookHelperList = new ArrayList<doBookHelper>();
        Book book;
        for (Upload upload : uploadList) {
            doBookHelper bookHelper = new doBookHelper();
            book = bookDao.queryById(upload.getUploadedbook());
            bookHelper.setId(book.getId());
            bookHelper.setTitle(book.getBooktitle());
            bookHelper.setAuthor(book.getBookauthor());
            bookHelper.setUploader(upload.getUploader());
            bookHelper.setUploadedDate(upload.getUploadeddate());
            doBookHelperList.add(bookHelper);
        }
        return doBookHelperList;
    }

    public List<doBookHelper> getUploadBooks() {
        List<doBookHelper> doBookHelperList;
        List<Upload> uploadList = uploadDao.queryByUploadedDate();
        doBookHelperList = iteratorUploadList(uploadList);
        return doBookHelperList;
    }

    public List<doBookHelper> getBooksByDays(int days) {
        List<doBookHelper> doBookHelperList;
        List<Upload> uploadList;
        if (days == 30) {
            uploadList = uploadDao.searchByThirtyDays();
        } else if (days == 7) {
            uploadList = uploadDao.searchBySevenDays();
        } else {
            uploadList = uploadDao.searchByToday();
        }
        doBookHelperList = iteratorUploadList(uploadList);
        return doBookHelperList;
    }

    public List<doBookHelper> getBooksByTitle(String title) {
        List<doBookHelper> doBookHelperList = new ArrayList<doBookHelper>();
        List<Book> bookList = bookDao.searchBookByTitle(title);
        for (Book book: bookList) {
            doBookHelper bookHelper = new doBookHelper();
            bookHelper.setId(book.getId());
            bookHelper.setTitle(book.getBooktitle());
            bookHelper.setAuthor(book.getBookauthor());
            Upload upload = uploadDao.queryByBookId(book.getId());
            bookHelper.setUploader(upload.getUploader());
            bookHelper.setUploadedDate(upload.getUploadeddate());
            doBookHelperList.add(bookHelper);
        }
        return doBookHelperList;
    }

    public List<doBookHelper> getBooksByUserId(long userId) {
        List<doBookHelper> doBookHelperList = new ArrayList<doBookHelper>();
        List<Upload> uploadList = uploadDao.queryByUserId(userId);
        Book book;
        for (Upload upload : uploadList) {
            book = bookDao.queryById(upload.getUploadedbook());
            doBookHelper bookHelper = new doBookHelper();
            bookHelper.setId(book.getId());
            bookHelper.setTitle(book.getBooktitle());
            bookHelper.setAuthor(book.getBookauthor());
            bookHelper.setUploader(upload.getUploader());
            bookHelper.setUploadedDate(upload.getUploadeddate());
            doBookHelperList.add(bookHelper);
        }
        return doBookHelperList;
    }

    public int deleteBook(long bookId) {
        Book book;
        book = bookDao.queryById(bookId);
        String bookFilePath = book.getBookfile();
        File file = new File(bookFilePath);
        if (file.exists()) {
            file.delete();
        } else {
            return 0;
        }
        String bookCoverPath = book.getBookcover();
        File cover = new File(bookCoverPath);
        if (cover.exists()) {
            cover.delete();
        } else {
            return 0;
        }
        int count = bookDao.deleteBook(bookId);
        int count2 = uploadDao.deleteUploadRow(bookId);
        if (count == 0 || count2 == 0) {
            return 0;
        }
        return 1;
    }

    public Map<String,Object> getUserByContribution() {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        List<User> userList = userDao.queryUserByContribution();
        resultMap.put("userList",userList);
        resultMap.put("totalUser",userDao.queryUserNumber());
        resultMap.put("weekUser",userDao.queryUserNumberByWeek());
        resultMap.put("monthUser",userDao.queryUserNumberByMonth());
        return resultMap;
    }

    public int deleteUser(long userId) {
        int count = userDao.deleteUser(userId);
        uploadDao.deleteUploadRowByUser(userId);
        if (count == 0) {
            return 0;
        }
        return 1;
    }

    public List<User> getUserBySearch(String searchTxt) {
        List<User> userList = new ArrayList<User>();
        if (searchTxt.length() < 5 ) {
            userList = userDao.queryUserByUserName(searchTxt);
        } else if (isNumeric(searchTxt)) {
            long userId = Long.parseLong(searchTxt);
            User user1 = userDao.queryById(userId);
            userList.add(user1);
            List<User> userList1 = userDao.queryUserByUserName(searchTxt);
            userList.addAll(userList1);
        }
        return userList;
    }

    public boolean isNumeric(String str) {
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public List<Feedback> getFeedback() {
        List<Feedback> feedbackList = feedbackDao.queryAllNotRead();
        return feedbackList;
    }

    public int setOneFeedbackRead(int id) {
        int count = feedbackDao.setOneRead(id);
        return count;
    }

    public int setAllFeedbackRead() {
        return feedbackDao.setAllRead();
    }
}
