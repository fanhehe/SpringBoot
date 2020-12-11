package com.fanhehe.user.business.user.pojo.respository.user;

import com.fanhehe.user.business.user.pojo.model.UserBinding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/11 11:44
 */
public interface UserBindingRepository extends JpaRepository<UserBinding, Long>, JpaSpecificationExecutor<UserBinding> {
    /**
     * 根据用户ID查询指定绑定关系
     * @param userId 用户
     * @param bindingType 绑定类型
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    Optional<UserBinding> findFirstByUserIdAndBindingType(Long userId, String bindingType);
}
