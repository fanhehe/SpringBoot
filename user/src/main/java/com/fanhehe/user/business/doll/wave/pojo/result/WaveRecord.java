package com.fanhehe.user.business.doll.wave.pojo.result;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 15:46
 */
public class WaveRecord {
    private String code;
    private String waveName;
    private String waveImage;
    private String roomCode;
    private long expireTime;
    private String openMethod;
    private long createTime;
    private int energyToOldUser;

    private Integer openMethodValue;
    private Integer openCurrentValue;

    private String waveStatus;
    private String waveStatusName;

    private String prizeType;
    private Double payPrice;

    private Integer position;

    private String wavePrizeMessage;
    private String waveNoticeMessage;
    private String waveShareMessage;
    private String waveOpenMessage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWaveName() {
        return waveName;
    }

    public void setWaveName(String waveName) {
        this.waveName = waveName;
    }

    public String getWaveImage() {
        return waveImage;
    }

    public void setWaveImage(String waveImage) {
        this.waveImage = waveImage;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public String getOpenMethod() {
        return openMethod;
    }

    public void setOpenMethod(String openMethod) {
        this.openMethod = openMethod;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getEnergyToOldUser() {
        return energyToOldUser;
    }

    public void setEnergyToOldUser(int energyToOldUser) {
        this.energyToOldUser = energyToOldUser;
    }

    public Integer getOpenMethodValue() {
        return openMethodValue;
    }

    public void setOpenMethodValue(Integer openMethodValue) {
        this.openMethodValue = openMethodValue;
    }

    public Integer getOpenCurrentValue() {
        return openCurrentValue;
    }

    public void setOpenCurrentValue(Integer openCurrentValue) {
        this.openCurrentValue = openCurrentValue;
    }

    public String getWaveStatus() {
        return waveStatus;
    }

    public void setWaveStatus(String waveStatus) {
        this.waveStatus = waveStatus;
    }

    public String getWaveStatusName() {
        return waveStatusName;
    }

    public void setWaveStatusName(String waveStatusName) {
        this.waveStatusName = waveStatusName;
    }

    public String getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType;
    }

    public Double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Double payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getWavePrizeMessage() {
        return wavePrizeMessage;
    }

    public void setWavePrizeMessage(String wavePrizeMessage) {
        this.wavePrizeMessage = wavePrizeMessage;
    }

    public String getWaveNoticeMessage() {
        return waveNoticeMessage;
    }

    public void setWaveNoticeMessage(String waveNoticeMessage) {
        this.waveNoticeMessage = waveNoticeMessage;
    }

    public String getWaveShareMessage() {
        return waveShareMessage;
    }

    public void setWaveShareMessage(String waveShareMessage) {
        this.waveShareMessage = waveShareMessage;
    }

    public String getWaveOpenMessage() {
        return waveOpenMessage;
    }

    public void setWaveOpenMessage(String waveOpenMessage) {
        this.waveOpenMessage = waveOpenMessage;
    }
}
