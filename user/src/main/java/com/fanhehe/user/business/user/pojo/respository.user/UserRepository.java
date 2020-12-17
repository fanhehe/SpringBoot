package com.fanhehe.user.business.user.pojo.respository.user;

import java.util.Optional;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.fanhehe.user.business.user.pojo.model.User;
import com.fanhehe.user.business.user.pojo.respository.CommonRepository;
import com.fanhehe.user.config.dataSource.DataSourceType;

/**
 * @author fanhehe
 */
@DS(DataSourceType.USER_CORE)
public interface UserRepository extends CommonRepository<User> {
    /**
     * 根据昵称获取用户
     *
     * @param userNick 昵称
     * @return 结果
     */
    @DS(DataSourceType.USER_CORE)
    Optional<User> findFirstByUserNickEquals(String userNick);
}
