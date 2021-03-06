package com.fanhehe.neckpets.business.wave.model;

import com.fanhehe.neckpets.business.wave.constant.WaveHighEnergy;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
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
@Table(name = "electric_wave_high_energy", schema = "doll", catalog = "")
public class ElectricWaveHighEnergy implements Serializable {
    private Long id;
    private String code;
    private Long userId;
    private Integer highEnergySeconds;
    private WaveHighEnergy status;
    private Date gmtDate;
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
    @Column(name = "high_energy_seconds", nullable = false)
    public Integer getHighEnergySeconds() {
        return highEnergySeconds;
    }

    public void setHighEnergySeconds(Integer highEnergySeconds) {
        this.highEnergySeconds = highEnergySeconds;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    public WaveHighEnergy getStatus() {
        return status;
    }

    public void setStatus(WaveHighEnergy status) {
        this.status = status;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectricWaveHighEnergy that = (ElectricWaveHighEnergy) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(highEnergySeconds, that.highEnergySeconds) &&
                Objects.equals(status, that.status) &&
                Objects.equals(gmtDate, that.gmtDate) &&
                Objects.equals(gmtCreate, that.gmtCreate) &&
                Objects.equals(gmtModify, that.gmtModify);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, userId, highEnergySeconds, status, gmtDate, gmtCreate, gmtModify);
    }
}
