package com.fanhehe.user.business.user.pojo.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author fanhehe
 */
@Entity
public class User implements Serializable {
    private long userId;
    private String userNick;
    private String userAvatar;
    private long createAt;
    private long updateAt;

    //    @JsonIgnoreProperties
//    @JSONField(serialize = false)
    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<UserBinding> bindingList;

    @Id
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_nick", nullable = false, length = 48)
    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    @Basic
    @Column(name = "user_avatar", nullable = false, length = 128)
    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    @Basic
    @Column(name = "create_at", nullable = false)
    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "update_at", nullable = false)
    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                createAt == user.createAt &&
                updateAt == user.updateAt &&
                Objects.equals(userNick, user.userNick) &&
                Objects.equals(userAvatar, user.userAvatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userNick, userAvatar, createAt, updateAt);
    }
}
