package com.fanhehe.user.business.user.pojo.respository.user;

import java.util.Optional;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.fanhehe.user.business.user.pojo.model.UserBinding;
import com.fanhehe.user.config.dataSource.DataSourceType;
import org.springframework.transaction.annotation.Transactional;
import com.fanhehe.user.business.user.pojo.respository.CommonRepository;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/11 11:44
 */
@DS(DataSourceType.USER_CORE)
public interface UserBindingRepository extends CommonRepository<UserBinding> {
    /**
     * 根据用户ID查询指定绑定关系
     *
     * @param userId      用户
     * @param bindingType 绑定类型
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    Optional<UserBinding> findFirstByUserIdAndBindingType(Long userId, String bindingType);
}
