package com.fanhehe.user.business.user.pojo.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/11 11:43
 */
@Entity
public class UserBinding implements Serializable {
    private Long id;
    private Long userId;
    private String bindingType;
    private String bindingUserName;
    private String bindingUserAvatar;
    private String bindingUserOpenId;
    private String bindingUserUnionId;
    private Long createAt;
    private Long updateAt;

    @ManyToOne
//    @JSONField(serialize = false)
//    @JsonIgnoreProperties
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "binding_type", nullable = false, length = 64)
    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    @Basic
    @Column(name = "binding_user_name", nullable = false, length = 64)
    public String getBindingUserName() {
        return bindingUserName;
    }

    public void setBindingUserName(String bindingUserName) {
        this.bindingUserName = bindingUserName;
    }

    @Basic
    @Column(name = "binding_user_avatar", nullable = false, length = 64)
    public String getBindingUserAvatar() {
        return bindingUserAvatar;
    }

    public void setBindingUserAvatar(String bindingUserAvatar) {
        this.bindingUserAvatar = bindingUserAvatar;
    }

    @Basic
    @Column(name = "binding_user_open_id", nullable = false, length = 64)
    public String getBindingUserOpenId() {
        return bindingUserOpenId;
    }

    public void setBindingUserOpenId(String bindingUserOpenId) {
        this.bindingUserOpenId = bindingUserOpenId;
    }

    @Basic
    @Column(name = "binding_user_union_id", nullable = false, length = 64)
    public String getBindingUserUnionId() {
        return bindingUserUnionId;
    }

    public void setBindingUserUnionId(String bindingUserUnionId) {
        this.bindingUserUnionId = bindingUserUnionId;
    }

    @Basic
    @Column(name = "create_at", nullable = false)
    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "update_at", nullable = false)
    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserBinding that = (UserBinding) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(bindingType, that.bindingType) &&
                Objects.equals(bindingUserName, that.bindingUserName) &&
                Objects.equals(bindingUserAvatar, that.bindingUserAvatar) &&
                Objects.equals(bindingUserOpenId, that.bindingUserOpenId) &&
                Objects.equals(bindingUserUnionId, that.bindingUserUnionId) &&
                Objects.equals(createAt, that.createAt) &&
                Objects.equals(updateAt, that.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, bindingType, bindingUserName, bindingUserAvatar, bindingUserOpenId, bindingUserUnionId, createAt, updateAt);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
