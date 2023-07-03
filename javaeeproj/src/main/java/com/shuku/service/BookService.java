package com.shuku.service;

import com.shuku.dao.BookDao;
import com.shuku.dao.BookTypeDao;
import com.shuku.dao.UploadDao;
import com.shuku.entity.Book;
import com.shuku.entity.BookType;
import com.shuku.entity.Upload;
import com.shuku.helper.PageHelper;
import com.shuku.helper.RankingBook;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//
@Service
public class BookService {

    private static final Log logger = LogFactory.getLog(BookService.class);

    @Autowired
    private BookTypeDao bookTypeDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UploadDao uploadDao;

    public Book getBookDetail(long id) {
        Book book;
        book = bookDao.queryById(id);
        return book;
    }

    public Upload getUploadInfo(long id) {
        Upload upload;
        upload = uploadDao.queryByBookId(id);
        return upload;
    }

    public List<BookType> getSmallTypesOfBook(String largeTypeName) {
        List<BookType> bookTypes;
        bookTypes = bookTypeDao.queryByLargeTypeName(largeTypeName);
        return bookTypes;
    }

    public long queryByTitle(String title) {
        Book book;
        book = bookDao.queryByTitle(title);
        return book.getId();
    }

    public List<String> getTypeNames(int id) {
        BookType bookType;
        bookType = bookTypeDao.queryById(id);
        List<String> typeNames = new ArrayList<String>();
        typeNames.add(bookType.getLargetypename());
        typeNames.add(bookType.getSmalltypename());
        return typeNames;
    }

    public void uploadBook(Book book) {
        int count = bookDao.addBook(book);
        if (count == 1) {
            logger.info("uploading successful!");
        } else {
            logger.info("uploading failed!");
        }
    }

    public void updateRecords(long uploader, long uploadedBook) {
        Upload upload = new Upload();
        upload.setUploader(uploader);
        upload.setUploadedbook(uploadedBook);
        Date uploadedDate = new Date();
        upload.setUploadeddate(uploadedDate);
        uploadDao.addUploadRecord(upload);
    }

    public List<Book> getLargeTypeBooks(List<BookType> bookTypes, PageHelper page) {
        List<Integer> bookTypeIdList = new ArrayList<Integer>();
        for (BookType bookType : bookTypes) {
            bookTypeIdList.add(bookType.getId());
        }
        List<Book> books = bookDao.getLargeTypeBooks(bookTypeIdList,page.getStartRow(),page.getPageSize());
        return books;
    }
    public int getTotalOfLTBooks(List<BookType> bookTypes) {
        List<Integer> bookTypeIdList = new ArrayList<Integer>();
        for (BookType bookType : bookTypes) {
            bookTypeIdList.add(bookType.getId());
        }
        return bookDao.getTotalOfLTBooks(bookTypeIdList);
    }

    public List<Book> getSmallTypeBooks(int typeid,PageHelper page) {
        List<Book> books = bookDao.getSmallTypeBooks(typeid,page.getStartRow(),page.getPageSize());
        return books;
    }

    public int getTotalOfSTBooks(int typeid) {
        return bookDao.getTotalOfSTBooks(typeid);
    }

    public int queryNumberOfBooks() {
        return bookDao.queryNumberOfBooks();
    }

    public List<Integer> queryNumberOfSomeTypeBooks() {
        List<Integer> result = new ArrayList<Integer>();
        for (int i=1; i<5; i++) {
            int sum = bookDao.queryNumberOfSomeTypeBooks(i);
            result.add(sum);
        }
        return result;
    }

    public String getMaxUploadDate() {
        Date date = uploadDao.getMaxUploadDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        String maxUploadDate = "";
        if (null != date) {
            maxUploadDate = dateFormat.format(date);
        }
        return maxUploadDate;
    }

    public List<RankingBook> queryByUploadedDate() {
        List<RankingBook> rankingBooks = new ArrayList<RankingBook>();
        List<Upload> uploadRecords;
        uploadRecords = uploadDao.queryByUploadedDate();
        Book book;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        for (Upload upload : uploadRecords) {
//            System.out.println("uploadR"+upload);
            RankingBook rankingBook = new RankingBook();
            rankingBook.setId(upload.getUploadedbook());
//            System.out.println("rankbook"+rankingBook.getId());
//            System.out.println("uploadget"+upload.getUploadedBook());
            book = bookDao.queryById(upload.getUploadedbook());
//            System.out.println("book"+book.getBook_title());
            rankingBook.setBookName(book.getBooktitle());
            String uploadDate = dateFormat.format(upload.getUploadeddate());
            rankingBook.setUploadDate(uploadDate);
            rankingBooks.add(rankingBook);
        }
//        System.out.println(rankingBooks);
        return rankingBooks;
    }

    public void addDownloadTimes(long id) {
        bookDao.addDownloadTimes(id);
    }

    public List<RankingBook> queryByDownloadTimes() {
        List<RankingBook> rankingBooks = new ArrayList<RankingBook>();
        List<Book> books;
        books = bookDao.queryByDownloadTimes();
        for (Book book : books) {
            RankingBook rankingBook = new RankingBook();
            rankingBook.setId(book.getId());
            rankingBook.setBookName(book.getBooktitle());
            rankingBook.setDownload_times(book.getDownloadtimes());
            rankingBooks.add(rankingBook);
        }
        return rankingBooks;
    }

    public List<Book> searchBook(String searchBy, String searchTxt) throws ParseException {
        List<Book> books;
        if (searchBy.equals("book_title")) {
            books = bookDao.searchBookByTitle(searchTxt);
        } else {
            books = bookDao.searchBookByAuthor(searchTxt);
        }
        return books;
    }


}
