package com.shuku.controller;

import com.shuku.dao.ContributionDao;
import com.shuku.entity.Avatar;
import com.shuku.entity.Contribution;
import com.shuku.entity.User;
import com.shuku.helper.UserHelper;
import com.shuku.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    private static final Log logger = LogFactory.getLog(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody User user, HttpSession session) {
        logger.info("you are logging in!");
        String userCode = user.getUsercode();
        String password = user.getUserpassword();
        System.out.println(userCode+password);
        UserHelper userHelper = userService.getLoginUser(userCode,password);
////        System.out.println(userHelper);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (null != userHelper && session.getAttribute("userHelper")==null) {
            session.setAttribute("userHelper",userHelper);
            resultMap.put("isLogined", true);
            resultMap.put("user", userHelper);
        } else {
            resultMap.put("isLogined", false);

        }
        return resultMap;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        logger.info("you have logged out!");
        // 清除会话（Session）
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // 清除本地Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        return "redirect:/index";
    }

}
