package com.shuku.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shuku.common.Result;
import com.shuku.entity.Tx;


import com.shuku.mapper.Txmapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tx")
public class Txcontroller {
    @Resource
    Txmapper txmapper;

    @PostMapping
    public Result<?> save(@RequestBody Tx tx) {
        //插入方法
        txmapper.insert(tx);
        return Result.success();
    }
    @PutMapping
    public Result<?> update(@RequestBody Tx tx ) {
        //更新方法

//        LambdaUpdateWrapper<Tx> updatawrapper = Wrappers.<Tx>lambdaUpdate();
        int update = txmapper.updateById(tx);
//        //System.out.print(update);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result<?> del(@PathVariable String id){
        //删除方法
        txmapper.deleteById(id);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer PageNum,
                              @RequestParam(defaultValue = "2") Integer PageSize,
                              @RequestParam(defaultValue = "") String search ) {
        //查询语句（pageNum:页数，pageSize：个数，wrapper.<Wz>lambdaQuery().like：查询方法，Wz:字段名，search:值）
        //避免值存留
        LambdaQueryWrapper<Tx> wrapper = Wrappers.<Tx>lambdaQuery();
        LambdaQueryWrapper<Tx> wrapper2 = Wrappers.<Tx>lambdaQuery();
        LambdaQueryWrapper<Tx> wrapper3 = Wrappers.<Tx>lambdaQuery();
        LambdaQueryWrapper<Tx> wrapper4 = Wrappers.<Tx>lambdaQuery();
        Page<Tx> wzPage0=null;
        if (StringUtils.isBlank(search)) {
            wrapper.like(Tx::getId, search);
            wzPage0 = txmapper.selectPage(new Page<>(PageNum, PageSize), wrapper);
        }else {
            wrapper2.like(Tx::getAvatartxt, search);
            Page<Tx> wzPage = txmapper.selectPage(new Page<>(PageNum, PageSize), wrapper2);
            if (wzPage.getRecords().size() != 0) {
                return Result.success(wzPage);
            } else {
                wrapper3.like(Tx::getAvatarimg, search);
                Page<Tx> wzPage2 = txmapper.selectPage(new Page<>(PageNum, PageSize), wrapper3);

                if (wzPage2.getRecords().size() != 0) {
                    return Result.success(wzPage2);
                }
            }
        }

        return Result.success(wzPage0);
    }
}
