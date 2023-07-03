package com.shuku.dao;


import com.shuku.entity.Avatar;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AvatarDao {

    /**
     * 通过头像编号获取图像
     */
    public Avatar queryById(int id);

    /**
     * 查询所有头像
     */
    public List<Avatar> queryAll();

    public int queryByImgPath(String avatarimg);
}
