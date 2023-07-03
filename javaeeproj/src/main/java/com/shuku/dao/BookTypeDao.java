package com.shuku.dao;


import com.shuku.entity.BookType;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookTypeDao {

    /**
     * 通过id查询图书类型

     */
    public BookType queryById(int id);

    /**
     * 通过主分类下的图书类型
     */
    public List<BookType> queryByLargeTypeName(String largeTypeName);
}
