package com.fanhehe.user.business.doll.wave.pojo.repository;

import com.fanhehe.user.business.doll.wave.pojo.ElectricWaveUserRecord;
import com.fanhehe.user.business.user.pojo.respository.CommonRepository;
import com.fanhehe.user.common.user.IUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 14:55
 */
public interface WaveUserRecordRepository extends CommonRepository<ElectricWaveUserRecord> {

    /**
     * 获取用户最新的一条电波
     *
     * @param user 用户
     * @return 获取用户最新的一条电波
     */
    @Query("from ElectricWaveUserRecord where userId=:#{#user.userId} order by id desc nulls first")
    ElectricWaveUserRecord getElectricWaveCycleUserRecord(@Param("user") IUser user);

    /**
     * 获取用户今天电波的总次数
     *
     * @param user    用户
     * @param gmtDate gmtDate
     * @return 结果
     */
    @Query("select count(*) from ElectricWaveUserRecord where userId=:#{#user.userId} and gmtDate=:gmtDate")
    int getElectricWaveCycleTodayTimes(@Param("user") IUser user, @Param("gmtDate") Date gmtDate);
}
