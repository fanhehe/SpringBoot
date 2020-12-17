package com.fanhehe.neckpets.business.wave.model;

import com.fanhehe.neckpets.business.wave.constant.WaveStatus;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/14 21:00
 */
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "electric_wave_user_record", schema = "doll", catalog = "")
public class ElectricWaveUserRecord {
    private Long id;
    private String code;
    private Long userId;
    private String waveCode;
    private String sourceType;
    private String sourceCode;
    private WaveStatus status;
    private Integer position;
    private Date gmtDate;
    private Timestamp gmtCreate;
    private Timestamp gmtModify;
    private ElectricWaveConfig waveConfig;
    private ElectricWaveHighEnergy highEnergy;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 64)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "wave_code", nullable = false, length = 64)
    public String getWaveCode() {
        return waveCode;
    }

    public void setWaveCode(String waveCode) {
        this.waveCode = waveCode;
    }

    @Basic
    @Column(name = "source_type", nullable = false, length = 64)
    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    @Basic
    @Column(name = "source_code", nullable = false, length = 64)
    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    public WaveStatus getStatus() {
        return status;
    }

    public void setStatus(WaveStatus status) {
        this.status = status;
    }

    @Basic
    @Column(name = "position", nullable = false)
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Basic
    @Column(name = "gmt_date", nullable = false)
    public Date getGmtDate() {
        return gmtDate;
    }

    public void setGmtDate(Date gmtDate) {
        this.gmtDate = gmtDate;
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

    @Lazy
    @ManyToOne
    @JoinColumn(name = "wave_code", referencedColumnName = "wave_code", insertable = false, updatable = false)
    public ElectricWaveConfig getWaveConfig() {
        return waveConfig;
    }

    public void setWaveConfig(ElectricWaveConfig waveConfig) {
        this.waveConfig = waveConfig;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectricWaveUserRecord that = (ElectricWaveUserRecord) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(waveCode, that.waveCode) &&
                Objects.equals(sourceType, that.sourceType) &&
                Objects.equals(sourceCode, that.sourceCode) &&
                Objects.equals(status, that.status) &&
                Objects.equals(position, that.position) &&
                Objects.equals(gmtDate, that.gmtDate) &&
                Objects.equals(gmtCreate, that.gmtCreate) &&
                Objects.equals(gmtModify, that.gmtModify);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, userId, waveCode, sourceType, sourceCode, status, position, gmtDate, gmtCreate, gmtModify);
    }

    @Lazy
    @OneToOne()
    @JoinColumn(name = "source_code", referencedColumnName = "code", insertable = false, updatable = false)
    public ElectricWaveHighEnergy getHighEnergy() {
        return highEnergy;
    }

    public void setHighEnergy(ElectricWaveHighEnergy highEnergy) {
        this.highEnergy = highEnergy;
    }
}
