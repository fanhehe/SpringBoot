package com.fanhehe.user.controller;

import com.fanhehe.user.pojo.PO.User;
import com.fanhehe.user.pojo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserCreateController {

    private UserRepository userRepository;

    @GetMapping("/user/create")
    @ResponseBody
    public String createUser(String phoneRegion, String phoneNumber) {

        User user = new User();
        user.setUserNick(phoneRegion);
        user.setUserAvatar(phoneNumber);
        user.setUserId((long)(Math.random() * 10000000000000000L));
        user.setCreateAt((int)(System.currentTimeMillis() / 1000));
        user.setUpdateAt((int)(System.currentTimeMillis() / 1000));

        userRepository.save(user);

        return user.toString();
    }

    @GetMapping("/user/query")
    @ResponseBody
    public User queryUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
