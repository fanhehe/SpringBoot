package com.fanhehe.user.business.user.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.fanhehe.user.business.user.pojo.constant.BindingType;
import com.fanhehe.user.business.user.pojo.model.User;
import com.fanhehe.user.business.user.pojo.model.UserBinding;
import com.fanhehe.user.business.user.pojo.respository.user.UserBindingRepository;
import com.fanhehe.user.business.user.pojo.respository.user.UserRepository;
import com.fanhehe.user.config.dataSource.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.LockModeType;
import java.util.Optional;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/11 11:51
 */
@RestController
@DS(DataSourceType.USER_CORE)
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserBindingRepository userInfoRepository;

    @GetMapping("binding-test")
    @Lock(LockModeType.PESSIMISTIC_READ)
    @Transactional(rollbackFor = Exception.class)
    public UserBinding index() {

        Long userId = 10003L;
        String bindingType = BindingType.QQ.getType();
        UserBinding binding = new UserBinding();

        User user = new User();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnorePaths("version")
                .withMatcher("id", mater -> mater.caseSensitive().regex().ignoreCase().exact());

        Optional<User> users = userRepository.findOne(Example.of(user,matcher));

        User b = users.orElse(userRepository.findFirstByUserNickEquals("3213213213").orElse(null));

        Optional<UserBinding> userBinding = userInfoRepository.findFirstByUserIdAndBindingType(userId, bindingType);

        if (!userBinding.isPresent()) {
            binding.setUserId(userId);
            binding.setBindingType(bindingType);
            binding.setBindingUserAvatar("");
            binding.setBindingUserName("");
            binding.setBindingUserOpenId("");
            binding.setBindingUserUnionId("");
            binding.setCreateAt(System.currentTimeMillis());
            binding.setUpdateAt(System.currentTimeMillis());
            userInfoRepository.save(binding);
        }

        return userBinding.orElse(binding);
    }
}
