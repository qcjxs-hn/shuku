package com.shuku.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shuku.common.Result;
import com.shuku.entity.User;
import com.shuku.mapper.Usermapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Date;
import java.text.SimpleDateFormat;

import static com.shuku.common.Timeconversion.timeconversion;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class Usercontroller {

    @Resource
    Usermapper usermapper;


    @PostMapping
    public Result<?> save(@RequestBody User user) {
        //插入方法
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setCreationdate(java.sql.Date.valueOf(sdf.format(date)));
        System.out.println(user.getAvatarnum());
        user.setAvatarnum(3);
        usermapper.insert(user);
        return Result.success();
    }

    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
        //登录方法
        System.out.print("user"+user.getUsercode());
        System.out.print(user.getUserpassword());
        User res = usermapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsercode, user.getUsercode()).eq(User::getUserpassword, user.getUserpassword()));
       // System.out.print(res);
//        session.setAttribute("userHelper",userHelper);
        if(res == null){
            return  Result.error("-1","用户名或密码错误！");
        }else {
            return Result.success(res);
        }
    }
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user){
        //注册方法
        //System.out.print("user"+user.getUserCode());
        //System.out.print(user.getUserPassword());
        User res = usermapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsercode, user.getUsercode()));
        // System.out.print(res);
        if(res != null){
            return  Result.error("-1","用户名重复！");
        }else {
            if (user.getUserpassword() == null) {
                user.setUserpassword("123456");
            }
            if(Character.isDigit( user.getUserpassword().charAt(0))){
                return  Result.error("-2","密码开头不能为数字！");
            }
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            user.setCreationdate(java.sql.Date.valueOf(sdf.format(date)));
            user.setContribution(0);
            user.setAvatarnum(3);
            usermapper.insert(user);
            return Result.success(res);
        }

    }
    @PutMapping
    public Result<?> update(@RequestBody User user){
        //更新方法
        usermapper.updateById(user);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result<?> del(@PathVariable Long id){
        //更新方法
        usermapper.deleteById(id);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer PageNum,
                              @RequestParam(defaultValue = "10") Integer PageSize,
                              @RequestParam(defaultValue = "") String search ) {
        //查询语句（pageNum:页数，pageSize：个数，wrapper.<User>lambdaQuery().like：查询方法，User:字段名，search:值）
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        LambdaQueryWrapper<User> wrapper2 = Wrappers.<User>lambdaQuery();
        LambdaQueryWrapper<User> wrapper3 = Wrappers.<User>lambdaQuery();
        Page<User> userPage0=null;
        if (StringUtils.isBlank(search)) {
            System.out.println(search);
            wrapper.like(User::getUsercode, search);
            userPage0 = usermapper.selectPage(new Page<>(PageNum, PageSize), wrapper);
        }else {
            wrapper.like(User::getUsercode, search);
            Page<User> userPage = usermapper.selectPage(new Page<>(PageNum, PageSize), wrapper);
            if (userPage.getRecords().size() != 0) {
                return Result.success(userPage);
            } else {
                wrapper2.like(User::getUsername, search);
                Page<User> userPage2 = usermapper.selectPage(new Page<>(PageNum, PageSize), wrapper2);
                //System.out.print("userpage2:"+userPage2.getRecords());
                //System.out.print("userpage2:"+userPage2.getRecords().size());
                if (userPage2.getRecords().size() != 0) {
                    return Result.success(userPage2);
                } else {
                    wrapper3.like(User::getEmail, search);
                    Page<User> userPage3 = usermapper.selectPage(new Page<>(PageNum, PageSize), wrapper3);
                    return Result.success(userPage3);
                }
            }
        }
       /* System.out.print(userPage.orders());
        System.out.print(userPage.getRecords());
        System.out.print(userPage.getSize());*/
        return Result.success(userPage0);
    }


}

