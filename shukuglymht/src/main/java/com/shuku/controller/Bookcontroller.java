package com.shuku.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shuku.common.Result;
import com.shuku.entity.Book;
import com.shuku.mapper.Bookmapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.shuku.common.Timeconversion.timeconversion;

@RestController
@RequestMapping("/book")
public class Bookcontroller {
    @Resource
    Bookmapper bookmapper;

    @PutMapping
    public Result<?> update(@RequestBody Book book) {
        //更新方法
        LambdaUpdateWrapper<Book> updatawrapper = Wrappers.<Book>lambdaUpdate();
        if(book.getBookpubyear().length()>20) {
            String newdate = timeconversion(book.getBookpubyear());
            book.setBookpubyear(newdate);

        }
        int update = bookmapper.updateById(book);
        System.out.print(update);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result<?> del(@PathVariable String id){

        //删除方法
//        LambdaQueryWrapper<Book> wrapperdel = Wrappers.<Book>lambdaQuery();
        bookmapper.deleteById( Long.parseLong(id));
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer PageNum,
                              @RequestParam(defaultValue = "10") Integer PageSize,
                              @RequestParam(defaultValue = "") String search ) {
        //查询语句（pageNum:页数，pageSize：个数，wrapper.<Wz>lambdaQuery().like：查询方法，Wz:字段名，search:值）
        //避免值存留
        LambdaQueryWrapper<Book> wrapper = Wrappers.<Book>lambdaQuery();
        LambdaQueryWrapper<Book> wrapper2 = Wrappers.<Book>lambdaQuery();
        LambdaQueryWrapper<Book> wrapper3 = Wrappers.<Book>lambdaQuery();
        LambdaQueryWrapper<Book> wrapper4 = Wrappers.<Book>lambdaQuery();
        Page<Book> wzPage0=null;
        if (StringUtils.isBlank(search)) {
            wrapper.like(Book::getBookauthor, search);
            wzPage0 = bookmapper.selectPage(new Page<>(PageNum, PageSize), wrapper);
        }else {
            wrapper2.like(Book::getBooktitle, search);
            Page<Book> wzPage = bookmapper.selectPage(new Page<>(PageNum, PageSize), wrapper2);
            if (wzPage.getRecords().size() != 0) {
                return Result.success(wzPage);
            } else {
                wrapper3.like(Book::getBooksummary, search);
                Page<Book> wzPage2 = bookmapper.selectPage(new Page<>(PageNum, PageSize), wrapper3);
                //System.out.print("wzpage2:"+wzPage2.getRecords());
                //System.out.print("wzpage2:"+wzPage2.getRecords().size());
                if (wzPage2.getRecords().size() != 0) {
                    return Result.success(wzPage2);
                } else {
                    wrapper4.like(Book::getTypeid, search);
                    Page<Book> wzPage3 = bookmapper.selectPage(new Page<>(PageNum, PageSize), wrapper4);
                    return Result.success(wzPage3);
                }
            }
        }
       /* System.out.print(wzPage.orders());
        System.out.print(wzPage.getRecords());
        System.out.print(wzPage.getSize());*/
        return Result.success(wzPage0);
    }


}

