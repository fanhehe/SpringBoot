package com.fanhehe.user.business.doll.wave.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 14:53
 */
@Entity
@Table(name = "electric_wave_config", schema = "doll")
public class ElectricWaveConfig {
    private Long id;
    private String waveName;
    private String waveCode;
    private String waveType;
    private String waveImage;
    private String waveSource;
    private String openMethod;
    private Integer openMethodValue;
    private String prizeType;
    private String prizeReference;
    private Double payPrice;
    private String roomCode;
    private String jumpRoomCode;
    private String userTagLimit;
    private Integer todayTimesCount;
    private Integer dailyTimesLimit;
    private String platformType;
    private String status;
    private Integer weight;
    private String wavePrizeMessage;
    private String waveShareMessage;
    private String waveNoticeMessage;
    private String waveOpenMessage;
    private Timestamp gmtCreate;
    private Timestamp gmtModify;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wave_name", nullable = false, length = 128)
    public String getWaveName() {
        return waveName;
    }

    public void setWaveName(String waveName) {
        this.waveName = waveName;
    }

    @Basic
    @Column(name = "wave_code", nullable = false, length = 64)
    public String getWaveCode() {
        return waveCode;
    }

    public void setWaveCode(String waveCode) {
        this.waveCode = waveCode;
    }

    @Basic
    @Column(name = "wave_type", nullable = false, length = 64)
    public String getWaveType() {
        return waveType;
    }

    public void setWaveType(String waveType) {
        this.waveType = waveType;
    }

    @Basic
    @Column(name = "wave_image", nullable = false, length = 128)
    public String getWaveImage() {
        return waveImage;
    }

    public void setWaveImage(String waveImage) {
        this.waveImage = waveImage;
    }

    @Basic
    @Column(name = "wave_source", nullable = false)
    public String getWaveSource() {
        return waveSource;
    }

    public void setWaveSource(String waveSource) {
        this.waveSource = waveSource;
    }

    @Basic
    @Column(name = "open_method", nullable = false)
    public String getOpenMethod() {
        return openMethod;
    }

    public void setOpenMethod(String openMethod) {
        this.openMethod = openMethod;
    }

    @Basic
    @Column(name = "open_method_value", nullable = false)
    public Integer getOpenMethodValue() {
        return openMethodValue;
    }

    public void setOpenMethodValue(Integer openMethodValue) {
        this.openMethodValue = openMethodValue;
    }

    @Basic
    @Column(name = "prize_type", nullable = false)
    public String getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType;
    }

    @Basic
    @Column(name = "prize_reference", nullable = false, length = 256)
    public String getPrizeReference() {
        return prizeReference;
    }

    public void setPrizeReference(String prizeReference) {
        this.prizeReference = prizeReference;
    }

    @Basic
    @Column(name = "pay_price", nullable = false, precision = 2)
    public Double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Double payPrice) {
        this.payPrice = payPrice;
    }

    @Basic
    @Column(name = "room_code", nullable = false, length = 256)
    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    @Basic
    @Column(name = "jump_room_code", nullable = false, length = 128)
    public String getJumpRoomCode() {
        return jumpRoomCode;
    }

    public void setJumpRoomCode(String jumpRoomCode) {
        this.jumpRoomCode = jumpRoomCode;
    }

    @Basic
    @Column(name = "user_tag_limit", nullable = false, length = 256)
    public String getUserTagLimit() {
        return userTagLimit;
    }

    public void setUserTagLimit(String userTagLimit) {
        this.userTagLimit = userTagLimit;
    }

    @Basic
    @Column(name = "today_times_count", nullable = false)
    public Integer getTodayTimesCount() {
        return todayTimesCount;
    }

    public void setTodayTimesCount(Integer todayTimesCount) {
        this.todayTimesCount = todayTimesCount;
    }

    @Basic
    @Column(name = "daily_times_limit", nullable = false)
    public Integer getDailyTimesLimit() {
        return dailyTimesLimit;
    }

    public void setDailyTimesLimit(Integer dailyTimesLimit) {
        this.dailyTimesLimit = dailyTimesLimit;
    }

    @Basic
    @Column(name = "platform_type", nullable = false, length = 128)
    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "weight", nullable = false)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "wave_prize_message", nullable = false, length = 256)
    public String getWavePrizeMessage() {
        return wavePrizeMessage;
    }

    public void setWavePrizeMessage(String wavePrizeMessage) {
        this.wavePrizeMessage = wavePrizeMessage;
    }

    @Basic
    @Column(name = "wave_share_message", nullable = false, length = 256)
    public String getWaveShareMessage() {
        return waveShareMessage;
    }

    public void setWaveShareMessage(String waveShareMessage) {
        this.waveShareMessage = waveShareMessage;
    }

    @Basic
    @Column(name = "wave_notice_message", nullable = false, length = 256)
    public String getWaveNoticeMessage() {
        return waveNoticeMessage;
    }

    public void setWaveNoticeMessage(String waveNoticeMessage) {
        this.waveNoticeMessage = waveNoticeMessage;
    }

    @Basic
    @Column(name = "wave_open_message", nullable = false, length = 256)
    public String getWaveOpenMessage() {
        return waveOpenMessage;
    }

    public void setWaveOpenMessage(String waveOpenMessage) {
        this.waveOpenMessage = waveOpenMessage;
    }

    @Basic
    @Column(name = "gmt_create", nullable = false)
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_modify", nullable = false)
    public Timestamp getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Timestamp gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectricWaveConfig that = (ElectricWaveConfig) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(waveName, that.waveName) &&
                Objects.equals(waveCode, that.waveCode) &&
                Objects.equals(waveType, that.waveType) &&
                Objects.equals(waveImage, that.waveImage) &&
                Objects.equals(waveSource, that.waveSource) &&
                Objects.equals(openMethod, that.openMethod) &&
                Objects.equals(openMethodValue, that.openMethodValue) &&
                Objects.equals(prizeType, that.prizeType) &&
                Objects.equals(prizeReference, that.prizeReference) &&
                Objects.equals(payPrice, that.payPrice) &&
                Objects.equals(roomCode, that.roomCode) &&
                Objects.equals(jumpRoomCode, that.jumpRoomCode) &&
                Objects.equals(userTagLimit, that.userTagLimit) &&
                Objects.equals(todayTimesCount, that.todayTimesCount) &&
                Objects.equals(dailyTimesLimit, that.dailyTimesLimit) &&
                Objects.equals(platformType, that.platformType) &&
                Objects.equals(status, that.status) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(wavePrizeMessage, that.wavePrizeMessage) &&
                Objects.equals(waveShareMessage, that.waveShareMessage) &&
                Objects.equals(waveNoticeMessage, that.waveNoticeMessage) &&
                Objects.equals(waveOpenMessage, that.waveOpenMessage) &&
                Objects.equals(gmtCreate, that.gmtCreate) &&
                Objects.equals(gmtModify, that.gmtModify);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, waveName, waveCode, waveType, waveImage, waveSource, openMethod, openMethodValue, prizeType, prizeReference, payPrice, roomCode, jumpRoomCode, userTagLimit, todayTimesCount, dailyTimesLimit, platformType, status, weight, wavePrizeMessage, waveShareMessage, waveNoticeMessage, waveOpenMessage, gmtCreate, gmtModify);
    }
}
