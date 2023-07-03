package com.shuku.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shuku.common.Result;
import com.shuku.entity.Upload;
import com.shuku.entity.User;
import com.shuku.mapper.Uploadmapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/upload")
public class Uploadcontroller {
    @Resource
    Uploadmapper uploadmapper;

    @PostMapping
    public Result<?> save(@RequestBody Upload upload) {
        //插入方法

        System.out.println(upload.getUploader());
        uploadmapper.insert(upload);
        return Result.success();
    }
    @PutMapping
    public Result<?> update(@RequestBody Upload upload ) {
        //更新方法


        int update = uploadmapper.updateById(upload);
//        //System.out.print(update);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result<?> del(@PathVariable String id){
        //删除方法

        uploadmapper.deleteById(id);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer PageNum,
                              @RequestParam(defaultValue = "2") Integer PageSize,
                              @RequestParam(defaultValue = "") String search ) {
        //查询语句（pageNum:页数，pageSize：个数，wrapper.<Wz>lambdaQuery().like：查询方法，Wz:字段名，search:值）
        //避免值存留
        LambdaQueryWrapper<Upload> wrapper = Wrappers.<Upload>lambdaQuery();
        LambdaQueryWrapper<Upload> wrapper2 = Wrappers.<Upload>lambdaQuery();
        LambdaQueryWrapper<Upload> wrapper3 = Wrappers.<Upload>lambdaQuery();
        LambdaQueryWrapper<Upload> wrapper4 = Wrappers.<Upload>lambdaQuery();
        Page<Upload> wzPage0=null;
        if (StringUtils.isBlank(search)) {
            wrapper.like(Upload::getId, search);
            wzPage0 = uploadmapper.selectPage(new Page<>(PageNum, PageSize), wrapper);
        }else {
            wrapper2.like(Upload::getUploader, search);
            Page<Upload> wzPage = uploadmapper.selectPage(new Page<>(PageNum, PageSize), wrapper2);
            if (wzPage.getRecords().size() != 0) {
                return Result.success(wzPage);
            } else {
                wrapper3.like(Upload::getUploadedbook, search);
                Page<Upload> wzPage2 = uploadmapper.selectPage(new Page<>(PageNum, PageSize), wrapper3);
                //System.out.print("wzpage2:"+wzPage2.getRecords());
                //System.out.print("wzpage2:"+wzPage2.getRecords().size());
                if (wzPage2.getRecords().size() != 0) {
                    return Result.success(wzPage2);
                } else {
                    wrapper4.like(Upload::getUploadeddate, search);
                    Page<Upload> wzPage3 = uploadmapper.selectPage(new Page<>(PageNum, PageSize), wrapper4);
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
