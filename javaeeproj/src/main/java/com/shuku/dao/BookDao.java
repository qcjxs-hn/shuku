package com.shuku.dao;

import com.shuku.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface BookDao {

    public Book queryById(long id);

    public int queryNumberOfBooks();

    public int queryNumberOfSomeTypeBooks(int largeType);

    public int addBook(Book book);

    public Book queryByTitle(String title);

    public List<Book> getLargeTypeBooks(@Param("list") List<Integer> booTypeList,
                                        @Param("startRow") int starRow,
                                        @Param("pageSize") int pageSize);

    public List<Book> getSmallTypeBooks(@Param("typeid") int typeid,
                                        @Param("startRow") int starRow,
                                        @Param("pageSize") int pageSize);

    public int addDownloadTimes(long id);

    public List<Book> queryByDownloadTimes();


    public List<Book> searchBookByTitle(String searchTxt);

    public List<Book> searchBookByAuthor(String searchTxt);

    public int getTotalOfLTBooks(List<Integer> booTypeList);

    public int getTotalOfSTBooks(int type_id);

    public int deleteBook(long id);
}
