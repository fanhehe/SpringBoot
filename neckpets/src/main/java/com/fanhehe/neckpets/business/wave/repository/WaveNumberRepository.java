package com.fanhehe.neckpets.business.wave.repository;

import com.fanhehe.neckpets.business.wave.pojo.bo.WaveNumber;
import com.fanhehe.neckpets.common.repository.CommonRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/15 08:24
 */
@NoRepositoryBean
public interface WaveNumberRepository extends CommonRepository<WaveNumber> {
}
