package com.fanhehe.user.business.doll.wave.pojo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fanhehe.user.business.doll.wave.pojo.ElectricWaveHighEnergy;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 14:54
 */
public interface WaveHighEnergyRepository extends JpaRepository<ElectricWaveHighEnergy, Long>, JpaSpecificationExecutor<ElectricWaveHighEnergy> {
}
