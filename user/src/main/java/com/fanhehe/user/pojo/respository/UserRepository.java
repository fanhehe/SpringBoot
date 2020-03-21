package com.fanhehe.user.pojo.respository;

import java.util.Optional;
import com.fanhehe.user.pojo.PO.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByUserNickEquals(String userNick);
}
