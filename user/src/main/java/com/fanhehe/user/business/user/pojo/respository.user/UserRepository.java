package com.fanhehe.user.business.user.pojo.respository.user;

import java.util.Optional;
import com.fanhehe.user.business.user.pojo.model.User;
import com.fanhehe.user.business.user.pojo.respository.CommonRepository;

/**
 * @author fanhehe
 */
public interface UserRepository extends CommonRepository<User> {
    /**
     * 根据昵称获取用户
     * @param userNick 昵称
     * @return 结果
     */
    Optional<User> findFirstByUserNickEquals(String userNick);
}
