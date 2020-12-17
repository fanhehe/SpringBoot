package com.fanhehe.neckpets.business.wave.repository.specification;

import com.fanhehe.neckpets.business.wave.model.ElectricWaveConfig;
import com.fanhehe.neckpets.business.wave.model.ElectricWaveHighEnergy_;
import com.fanhehe.neckpets.business.wave.model.ElectricWaveUserRecord;
import com.fanhehe.neckpets.business.wave.model.ElectricWaveUserRecord_;
import com.fanhehe.neckpets.business.wave.pojo.bo.WaveNumber;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/15 08:19
 */
public interface WaveNumberSpec {
    static Specification<WaveNumber> getNumberOfWave() {
        return (root, cq, cb) -> {
            CriteriaQuery<WaveNumber> query = cb.createQuery(WaveNumber.class);

            query.from(ElectricWaveUserRecord.class);

            query.groupBy(root.get("userId"));
            query.multiselect(root.get("userId"), cb.count(root.get("id")));

            return cb.and(query.getGroupRestriction());
        };
    }

    static Specification<WaveNumber> getNumberOfWaves() {
        return (root, cq, cb) -> cq.getRestriction();
    }
}
