package org.hgq.mapper;

import org.hgq.pojo.Book;

import java.util.List;

public interface BookMapper {
    //查询全部图书
    List<Book> getAll();
}
