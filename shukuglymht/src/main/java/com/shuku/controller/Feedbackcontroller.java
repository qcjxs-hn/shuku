package com.shuku.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shuku.common.Result;
import com.shuku.entity.Feedback;
import com.shuku.mapper.Feedbackmapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/feedback")
public class Feedbackcontroller {
    @Resource
    Feedbackmapper feedbackmapper;

    @PutMapping
    public Result<?> update(@RequestBody Feedback feedback){
        //更新方法
        LambdaUpdateWrapper<Feedback> updatawrapper = Wrappers.<Feedback>lambdaUpdate();
        int update = feedbackmapper.update(feedback, updatawrapper.like(Feedback::getContact, feedback.getContact()));
        System.out.print(update);
        return Result.success();
    }
    @DeleteMapping("/{contact}")
    public Result<?> del(@PathVariable String contact){
        //更新方法
        LambdaQueryWrapper<Feedback> wrapperdel = Wrappers.<Feedback>lambdaQuery();
        feedbackmapper.delete( wrapperdel.like(Feedback::getContact,contact));
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer PageNum,
                              @RequestParam(defaultValue = "5") Integer PageSize,
                              @RequestParam(defaultValue = "") String search ) {
        //查询语句（pageNum:页数，pageSize：个数，wrapper.<feedback>lambdaQuery().like：查询方法，feedback:字段名，search:值）
        //避免值存留
        LambdaQueryWrapper<Feedback> wrapper = Wrappers.<Feedback>lambdaQuery();
        LambdaQueryWrapper<Feedback> wrapper2 = Wrappers.<Feedback>lambdaQuery();
        LambdaQueryWrapper<Feedback> wrapper3 = Wrappers.<Feedback>lambdaQuery();
        LambdaQueryWrapper<Feedback> wrapper4 = Wrappers.<Feedback>lambdaQuery();
        LambdaQueryWrapper<Feedback> wrapper5 = Wrappers.<Feedback>lambdaQuery();
        Page<Feedback> feedbackPage0=null;
        if (StringUtils.isBlank(search)) {
            wrapper.like(Feedback::getLogineduser, search);
            feedbackPage0 = feedbackmapper.selectPage(new Page<>(PageNum, PageSize), wrapper);
        }else {
            wrapper2.like(Feedback::getContact, search);
            Page<Feedback> feedbackPage = feedbackmapper.selectPage(new Page<>(PageNum, PageSize), wrapper2);
            if (feedbackPage.getRecords().size() != 0) {
                return Result.success(feedbackPage);
            } else {
                wrapper3.like(Feedback::getSuggestion, search);
                Page<Feedback> feedbackPage2 = feedbackmapper.selectPage(new Page<>(PageNum, PageSize), wrapper3);
                //System.out.print("feedbackpage2:"+feedbackPage2.getRecords());
                //System.out.print("feedbackpage2:"+feedbackPage2.getRecords().size());
                if (feedbackPage2.getRecords().size() != 0) {
                    return Result.success(feedbackPage2);
                } else {
                    wrapper4.like(Feedback::getStatus, search);
                    Page<Feedback> feedbackPage3 = feedbackmapper.selectPage(new Page<>(PageNum, PageSize), wrapper4);
                    if(feedbackPage3.getRecords().size()!=0){
                        return Result.success(feedbackPage3);
                    }
                    else{
                        wrapper5.like(Feedback::getPosttime,search);
                        Page<Feedback> feedbackPage4 = feedbackmapper.selectPage(new Page<>(PageNum, PageSize), wrapper5);
                        return Result.success(feedbackPage4);
                    }

                }
            }
        }
       /* System.out.print(feedbackPage.orders());
        System.out.print(feedbackPage.getRecords());
        System.out.print(feedbackPage.getSize());*/
        return Result.success(feedbackPage0);
    }


}

