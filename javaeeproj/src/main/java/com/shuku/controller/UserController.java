package com.shuku.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuku.entity.User;
import com.shuku.helper.UploadHelper;
import com.shuku.helper.UserHelper;
import com.shuku.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    private static final Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/person")
    public String getPerosonInfo(@RequestParam("userList") String userListJson, Model model, HttpSession session) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            UserHelper[] userArray = objectMapper.readValue(userListJson, UserHelper[].class);
            UserHelper userHelper=userArray[0];
            System.out.println(userHelper.getId());
            session.setAttribute("userHelper",userHelper);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserHelper userHelper = (UserHelper) session.getAttribute("userHelper");
        if (null == userHelper) {
            return "redirect:index";
        }
        model.addAttribute("user", userHelper);
        logger.info("The user(" + userHelper.getUsername() + ") is coming to person information page!");
        return "personInfo";
    }

    @RequestMapping(value = "/infoModify")
    public String infoModify(@RequestParam("userList") String userListJson,String name, String email, String avatarImg, HttpSession session) {
        logger.info("The user is modifying his information!");
        UserHelper userHelper = (UserHelper) session.getAttribute("userHelper");
        User user = new User();
        user.setId(userHelper.getId());
        user.setUsername(name);
        user.setEmail(email);
//        logger.info(avatarImg);
        int avatarId = userService.getAvatarId(avatarImg);
//        System.out.println("a"+avatarId+"");
        user.setAvatarNum(avatarId);
        userService.updateUserInfo(user);
        User user1;
        user1 = userService.queryById(userHelper.getId());
        UserHelper newUserHelper;
        newUserHelper = userService.getLoginUser(user1.getUsercode(),user1.getUserpassword());
        session.setAttribute("userHelper",newUserHelper);
        return "redirect:/person?userList="+userListJson;
    }

    @RequestMapping(value = "/pwdModify")
    public String pwdModify(String newPwd, HttpSession session) {
        logger.info("The user is modifying his password!");
        UserHelper userHelper = (UserHelper) session.getAttribute("userHelper");
        System.out.println(userHelper.getId()+""+newPwd);
        userService.updateUserPassword(userHelper.getId(), newPwd);
        session.invalidate();
        return "redirect:/index";
    }

    @RequestMapping(value = "/getUploadHistory")
    @ResponseBody
    public Map<String,Object> getUploadHistory(HttpSession session) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        UserHelper userHelper = (UserHelper) session.getAttribute("userHelper");
        List<UploadHelper> uploadHelperList = userService.getUploadedBook(userHelper.getId());
        resultMap.put("uploadList", uploadHelperList);
        logger.info("you are looking up the uploaded books");
        return resultMap;
    }

    @RequestMapping(value = "/feedback")
    @ResponseBody
    public void feedback(String contact, String suggestion,HttpSession session) {
        UserHelper userHelper = (UserHelper) session.getAttribute("userHelper");
        userService.addFeedback(userHelper.getId(),contact,suggestion);
        logger.info("you are posting the suggestion!");
        logger.info("contact:" + contact);
        logger.info("suggestion:" + suggestion);
    }
}
