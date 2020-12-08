package com.fanhehe.user.pojo.respository.user;

import java.util.Optional;
import com.fanhehe.user.pojo.PO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author fanhehe
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    Optional<User> findFirstByUserNickEquals(String userNick);
}
