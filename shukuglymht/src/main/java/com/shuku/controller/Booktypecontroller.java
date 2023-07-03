package com.shuku.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shuku.common.Result;
import com.shuku.entity.Booktype;
import com.shuku.entity.Contribution;
import com.shuku.mapper.Booktypemapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.shuku.common.Timeconversion.timeconversion;

@RestController
@RequestMapping("/booktype")
public class Booktypecontroller {
    @Resource
    Booktypemapper booktypemapper;
    @PostMapping
    public Result<?> save(@RequestBody Booktype booktype) {
        //插入方法
        booktypemapper.insert(booktype);
        return Result.success();
    }
    @PutMapping
    public Result<?> update(@RequestBody Booktype booktype){
        //更新方法

        if(booktype.getId()!=0) {
            LambdaUpdateWrapper<Booktype> updatawrapper = Wrappers.<Booktype>lambdaUpdate();

            int update = booktypemapper.update(booktype, updatawrapper.eq(Booktype::getId, booktype.getId()));
        }
        else{
            LambdaQueryWrapper<Booktype> wrapper = Wrappers.<Booktype>lambdaQuery();
            LambdaUpdateWrapper<Booktype> updatawrapper = Wrappers.<Booktype>lambdaUpdate();
            wrapper.like(Booktype::getId, "");
            List<Booktype> booktypePage7 =  booktypemapper.selectList(wrapper);
            //根据库的长度生成
            booktype.setId(booktypePage7.size()+1);
            int update = booktypemapper.insert(booktype);
           // System.out.print(update);
        }
        //System.out.print(update);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result<?> del(@PathVariable Integer id){
        //删除方法
        LambdaQueryWrapper<Booktype> wrapperdel = Wrappers.<Booktype>lambdaQuery();
        booktypemapper.delete( wrapperdel.like(Booktype::getId,id));
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer PageNum,
                              @RequestParam(defaultValue = "5") Integer PageSize,
                              @RequestParam(defaultValue = "") String search ) {
        //查询语句（pageNum:页数，pageSize：个数，wrapper.<Wzms>lambdaQuery().like：查询方法，Wzms:字段名，search:值）
        //避免值存留
        LambdaQueryWrapper<Booktype> wrapper = Wrappers.<Booktype>lambdaQuery();
        LambdaQueryWrapper<Booktype> wrapper2 = Wrappers.<Booktype>lambdaQuery();
        LambdaQueryWrapper<Booktype> wrapper3 = Wrappers.<Booktype>lambdaQuery();
        LambdaQueryWrapper<Booktype> wrapper4 = Wrappers.<Booktype>lambdaQuery();
        LambdaQueryWrapper<Booktype> wrapper5 = Wrappers.<Booktype>lambdaQuery();
        Page<Booktype> wzmsPage0=null;
        if (StringUtils.isBlank(search)) {
            wrapper.like(Booktype::getId, search);
            wzmsPage0 = booktypemapper.selectPage(new Page<>(PageNum, PageSize), wrapper);
        }else {
            wrapper2.like(Booktype::getBooklargetype, search);
            Page<Booktype> wzmsPage = booktypemapper.selectPage(new Page<>(PageNum, PageSize), wrapper2);
            if (wzmsPage.getRecords().size() != 0) {
                return Result.success(wzmsPage);
            } else {
                wrapper3.like(Booktype::getBooksmalltype, search);
                Page<Booktype> wzmsPage2 = booktypemapper.selectPage(new Page<>(PageNum, PageSize), wrapper3);
                //System.out.print("wzmspage2:"+wzmsPage2.getRecords());
                //System.out.print("wzmspage2:"+wzmsPage2.getRecords().size());
                if (wzmsPage2.getRecords().size() != 0) {
                    return Result.success(wzmsPage2);
                } else {
                    wrapper4.like(Booktype::getLargetypename, search);
                    Page<Booktype> wzmsPage3 = booktypemapper.selectPage(new Page<>(PageNum, PageSize), wrapper4);
                    if(wzmsPage3.getRecords().size()!=0){
                        return Result.success(wzmsPage3);
                    }
                    else{
                        wrapper5.like(Booktype::getSmalltypename,search);
                        Page<Booktype> wzmsPage4 = booktypemapper.selectPage(new Page<>(PageNum, PageSize), wrapper5);
                        return Result.success(wzmsPage4);
                    }

                }
            }
        }
       /* System.out.print(wzmsPage.orders());
        System.out.print(wzmsPage.getRecords());
        System.out.print(wzmsPage.getSize());*/
        return Result.success(wzmsPage0);
    }


}

