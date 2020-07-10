package com.fanhehe.user.controller;

import com.fanhehe.user.pojo.PO.User;
import com.fanhehe.proto.user.UserOuterClass;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.fanhehe.user.pojo.respository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@CacheConfig(cacheNames = "user")
public class UserCreateController {

    private UserRepository userRepository;

    public UserCreateController() {
        int a = 1;
        int b = 2;
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/user/create")
    @ResponseBody
    @CachePut
//    @CacheEvict
    public String createUser(String phoneRegion, String phoneNumber) {

        Long result = redisTemplate.opsForSet().add("xxxxxxx", "xxxxxxx");

        UserOuterClass.User xxx = UserOuterClass
                .User.newBuilder()
                .setUserId(1L)
                .setUserToken("")
                .build();

        User user = new User();
        user.setUserNick(phoneRegion);
        user.setUserAvatar(phoneNumber);
        user.setUserId((long) (Math.random() * 10000000000000000L));
        user.setCreateAt((int) (System.currentTimeMillis() / 1000));
        user.setUpdateAt((int) (System.currentTimeMillis() / 1000));

        userRepository.save(user);

        return user.toString();
    }

    @GetMapping("/user/query")
    @ResponseBody
    @Cacheable(key = "#userId")
    public User queryUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        rabbitTemplate.convertAndSend("topic", "query_user.3", user);
        return user;
    }

    @GetMapping("/user/query-nick")
    @ResponseBody
    public User queryUser(@NotBlank String userNick) {
        return userRepository.findFirstByUserNickEquals(userNick).orElse(null);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
