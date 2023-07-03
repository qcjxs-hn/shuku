package com.shuku.dao;


import com.shuku.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 通过id查找用户

     */
    public User queryById(long id);

    /**
     * 通过用户名和密码查询用户信息

     */
    public User queryByLogin(@Param("usercode") String userCode,
                             @Param("userpassword") String userPassword);

    /**
     * 查询用户名是否存在

     */
    public int queryByUserCode(String userCode);

    /**
     * 添加用户
     */
    public int addUser(User user);

    public int updateUserPassword(@Param("id") long id,
                                  @Param("userpassword") String userPassword);

    public int updateUserContribution(@Param("addValue") int addValue,
                                      @Param("id") long id);

    public int updateUserInfo(User user);

    public List<User> queryUserByContribution();

    public int queryUserNumber();

    public int queryUserNumberByWeek();

    public int queryUserNumberByMonth();

    public int deleteUser(long id);

    public List<User> queryUserByUserName(String userName);

}
