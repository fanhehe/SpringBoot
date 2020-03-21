package com.fanhehe.user.pojo.PO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable {
    private long userId;
    private String userNick;
    private String userAvatar;
    private int createAt;
    private int updateAt;

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
    public int getCreateAt() {
        return createAt;
    }

    public void setCreateAt(int createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "update_at", nullable = false)
    public int getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(int updateAt) {
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
