package com.shuku.service;

import com.shuku.dao.*;
import com.shuku.entity.*;
import com.shuku.helper.UploadHelper;
import com.shuku.helper.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AvatarDao avatarDao;
    @Autowired
    private ContributionDao contributionDao;
    @Autowired
    private FeedbackDao feedbackDao;
    @Autowired
    private UploadDao uploadDao;
    @Autowired
    private BookDao bookDao;

    public User queryById(long id) {
        User user;
        user = userDao.queryById(id);
        return user;
    }

    public UserHelper getLoginUser(String userCode, String userPassword) {
        System.out.println(userCode+userPassword);
        User user = userDao.queryByLogin(userCode, userPassword);
//        System.out.println(user.getUsername());
        if (null != user) {
            Avatar avatar = avatarDao.queryById(user.getAvatarnum());
            System.out.println(avatar.getId());
            Contribution contribution = contributionDao.queryByValue(user.getContribution());
            UserHelper userHelper = new UserHelper();
            userHelper.setId(user.getId());
            userHelper.setUsercode(user.getUsercode());
            userHelper.setUsername(user.getUsername());
            userHelper.setEmail(user.getEmail());
            userHelper.setAvatar(avatar);
            userHelper.setContributionValue(user.getContribution());
            userHelper.setContribution(contribution);
            userHelper.setCreationdate(user.getCreationdate());
            return userHelper;
        } else {
            return null;
        }
    }
    public UserHelper getLogoutUser() {
            UserHelper userHelper = new UserHelper();
            userHelper.setId(0);
            userHelper.setUsercode("");
            userHelper.setUsername("");
            userHelper.setEmail("");
            return userHelper;
    }

    public int checkUserCode(String userCode) {
        int count = userDao.queryByUserCode(userCode);
        return count;
    }

    public void addUser(User user) {
        int avatarNum = new Random().nextInt(10) + 1;
        user.setAvatarNum(avatarNum);
        user.setContribution(0);
        Date date = new Date();
        user.setCreationdate(date);
        userDao.addUser(user);
    }

    public void updateUserContribution(int addValue,long userID) {
        userDao.updateUserContribution(addValue,userID);
    }

    public void updateUserInfo(User user) {
        userDao.updateUserInfo(user);
    }

    public int getAvatarId(String avatar_img) {
//        System.out.println("av"+avatar_img);
        int avatarId = avatarDao.queryByImgPath(avatar_img);
//        System.out.println(avatarId);
        return avatarId;
    }

    public void updateUserPassword(long id, String password ) {
        userDao.updateUserPassword(id, password);
    }

    public void addFeedback(long userId, String contact, String suggestion) {
        Feedback feedback = new Feedback();
        feedback.setLoginedUser(userId);
        feedback.setContact(contact);
        feedback.setSuggestion(suggestion);
        feedback.setPostTime(new Timestamp(new Date().getTime()));
        feedbackDao.addFeedback(feedback);
    }

    public List<UploadHelper> getUploadedBook(long userId) {
        List<UploadHelper> uploadHelperList = new ArrayList<UploadHelper>();
        List<Upload> uploadList;
        uploadList = uploadDao.queryByUserId(userId);
        for (int i=0; i<uploadList.size(); i++) {
            UploadHelper upload = new UploadHelper();
            upload.setId(i+1);
            Book book = bookDao.queryById(uploadList.get(i).getUploadedbook());
            upload.setBookTitle(book.getBooktitle());
            upload.setBookAuthor(book.getBookauthor());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String uploadDate = dateFormat.format(uploadList.get(i).getUploadeddate());
            upload.setUploadedDate(uploadDate);
            upload.setDownloadTimes(book.getDownloadtimes());
            uploadHelperList.add(upload);
        }
        return uploadHelperList;
    }

}
