package com.fanhehe.user.pojo.respository;

import com.fanhehe.user.pojo.PO.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
