package com.shuku.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shuku.common.Result;

import com.shuku.entity.Contribution;
import com.shuku.entity.Tx;
import com.shuku.mapper.Contributionmapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.shuku.common.Timeconversion.timeconversion;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/contribution")
public class Contributioncontroller {
    @Resource
    Contributionmapper contributionmapper;

    @PostMapping
    public Result<?> save(@RequestBody Contribution contribution) {
        //插入方法
        contributionmapper.insert(contribution);
        return Result.success();
    }
    @PutMapping
    public Result<?> update(@RequestBody Contribution contribution ) {
        //更新方法


        int update = contributionmapper.updateById(contribution);
//        //System.out.print(update);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result<?> del(@PathVariable String id){
        //删除方法

        contributionmapper.deleteById(id);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer PageNum,
                              @RequestParam(defaultValue = "2") Integer PageSize,
                              @RequestParam(defaultValue = "") String search ) {
        //查询语句（pageNum:页数，pageSize：个数，wrapper.<Wz>lambdaQuery().like：查询方法，Wz:字段名，search:值）
        //避免值存留
        LambdaQueryWrapper<Contribution> wrapper = Wrappers.<Contribution>lambdaQuery();
        LambdaQueryWrapper<Contribution> wrapper2 = Wrappers.<Contribution>lambdaQuery();
        LambdaQueryWrapper<Contribution> wrapper3 = Wrappers.<Contribution>lambdaQuery();
        LambdaQueryWrapper<Contribution> wrapper4 = Wrappers.<Contribution>lambdaQuery();
        Page<Contribution> wzPage0=null;
        String searchcl="";
        if(search.equals("")) {
        }else{
            if (Integer.parseInt(search) >= 0 && Integer.parseInt(search) <= 20) {
                searchcl = "1";
            } else if (Integer.parseInt(search) >= 21 && Integer.parseInt(search) <= 50) {
                searchcl = "2";
            } else if (Integer.parseInt(search) >= 51 && Integer.parseInt(search) <= 100) {
                searchcl = "3";
            } else if (Integer.parseInt(search) >= 101 && Integer.parseInt(search) <= 200) {
                searchcl = "4";
            } else if (Integer.parseInt(search) >= 201 && Integer.parseInt(search) <= 999999) {
                searchcl = "5";
            }
        }
        if (StringUtils.isBlank(search)) {
            wrapper.like(Contribution::getLeveltxt, search);

            wzPage0 = contributionmapper.selectPage(new Page<>(PageNum, PageSize), wrapper);
        }else {
            wrapper2.like(Contribution::getId, searchcl);
            Page<Contribution> wzPage = contributionmapper.selectPage(new Page<>(PageNum, PageSize), wrapper2);
            if (wzPage.getRecords().size() != 0) {
                return Result.success(wzPage);
            } else {
                wrapper3.like(Contribution::getUpperlimit, search);
                Page<Contribution> wzPage2 = contributionmapper.selectPage(new Page<>(PageNum, PageSize), wrapper3);
                //System.out.print("wzpage2:"+wzPage2.getRecords());
                //System.out.print("wzpage2:"+wzPage2.getRecords().size());
                if (wzPage2.getRecords().size() != 0) {
                    return Result.success(wzPage2);
                } else {
                    wrapper4.like(Contribution::getLevelimg, search);
                    Page<Contribution> wzPage3 = contributionmapper.selectPage(new Page<>(PageNum, PageSize), wrapper4);
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
