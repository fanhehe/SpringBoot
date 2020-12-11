package com.fanhehe.user.business.user.pojo.respository.user;

import java.util.Optional;
import com.fanhehe.user.business.user.pojo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author fanhehe
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    /**
     * 根据昵称获取用户
     * @param userNick 昵称
     * @return 结果
     */
    Optional<User> findFirstByUserNickEquals(String userNick);
}
