package com.fanhehe.user.business.user.pojo.respository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author fanhehe
 */
@NoRepositoryBean
public interface CommonRepository<T> extends BaseRepository<T, Long> {
}
