package com.fanhehe.user.pojo.respository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
@NoRepositoryBean
public interface CommonRepository<T>extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
