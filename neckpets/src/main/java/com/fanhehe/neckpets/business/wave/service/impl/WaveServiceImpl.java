package com.fanhehe.neckpets.business.wave.service.impl;

import com.fanhehe.neckpets.business.wave.model.*;
import com.fanhehe.neckpets.business.wave.pojo.bo.WaveNumber;
import com.fanhehe.neckpets.business.wave.repository.WaveConfigRepository;
import com.fanhehe.neckpets.business.wave.repository.WaveUserRecordRepository;
import com.fanhehe.neckpets.business.wave.repository.specification.WaveNumberSpec;
import com.fanhehe.neckpets.business.wave.service.WaveService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/14 20:54
 */
@Service
public class WaveServiceImpl implements WaveService {

    @Autowired
    private WaveConfigRepository waveConfigRepository;

    @Autowired
    private WaveUserRecordRepository waveUserRecordRepository;

    @Autowired
    private WaveNumberSpec waveNumberSpec;

    @Autowired
    private EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(WaveServiceImpl.class);

    @Override
    @SneakyThrows
    public void testFind() {


        if (true) {

            // join查询
//            List<Predicate> predicates = new ArrayList<>();
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<WaveNumber> query = cb.createQuery(WaveNumber.class);
//            Root<ElectricWaveUserRecord> root = query.from(ElectricWaveUserRecord.class);
//            Join<ElectricWaveUserRecord, ElectricWaveHighEnergy> join = root.join("highEnergy", JoinType.LEFT);
//            join = join.on(cb.equal(root.get(ElectricWaveUserRecord_.SOURCE_CODE), join.get(ElectricWaveHighEnergy_.CODE)));
//            predicates.add(cb.isNotNull(join.get(ElectricWaveHighEnergy_.ID)));
//            query.groupBy(root.get(ElectricWaveUserRecord_.USER_ID));
//            query.multiselect(root.get((ElectricWaveUserRecord_.USER_ID)), cb.count(root.get(ElectricWaveUserRecord_.ID)));
//            query.where(predicates.toArray(new Predicate[]{}));
//
//            List<WaveNumber> r = entityManager.createQuery(query).getResultList();
//            r.size();
        }

        if (true) {
//            CriteriaBuilder builder = em.getCriteriaBuilder();
//            CriteriaQuery<NotificationInfo> cq = builder.createQuery(NotificationInfo.class); //wrapper class
//            Root<Notification> n = cq.from(Notification.class); //root entity
//
//            Subquery<Long> sqSent = cq.subquery(Long.class);
//            Root<NotificationUser> sqSentNU = sqSent.from(NotificationUser.class);
//            sqSent.select(builder.count(sqSentNU));
//            sqSent.where(
//                    builder.equal(sqSentNU.get(NotificationUser_.notification), n),  //join subquery with main query
//                    builder.isNotNull(sqSentNU.get(NotificationUser_.sendDate))
//            );
//
//            cq.select(
//                    builder.construct(
//                            NotificationInfo.class,
//                            n.get(Notification_.idNotification),
//                            n.get(Notification_.creationDate),
//                            n.get(Notification_.suspendedDate),
//                            n.get(Notification_.type),
//                            n.get(Notification_.title),
//                            n.get(Notification_.description),
//                            sqSent.getSelection()
//                    )
//            );
//            em.createQuery(cq).getResultList();
        }

//        List<ElectricWaveUserRecord> configList = waveUserRecordRepository.findAll((root, cq, cb) -> {
//            return cb.and(cb.equal(root.get("userId"), 89030819));
//        });
//
//        List<ElectricWaveUserRecord> b = waveUserRecordRepository.findAll((root, cq, cb) -> {
//            return cb.equal(root.get(ElectricWaveUserRecord_.userId), 89030819);
//        });
//
//       List<ElectricWaveUserRecord> a = waveUserRecordRepository.findAll(((root, cq, cb) -> {
//            return cq
//                    .multiselect(root.get("userId"), cb.count(root.get("userId")).alias("cs"))
//                    .distinct(true)
//                    .groupBy(root.get("userId"))
//                    .getRestriction()
//                    ;
//        }));
//
//       int page = 1;
//       List<ElectricWaveUserRecord> arrayList = new ArrayList<>();
//       Page<ElectricWaveUserRecord> list;
//       do {
//
//           list = waveUserRecordRepository
//                   .findAll(PageRequest.of(page, 20, Sort.by("id")));
//           page++;
//           arrayList.addAll(list.getContent());
//
//
//       } while (list.hasNext());
//
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<WaveNumber> query = builder.createQuery(WaveNumber.class);
//        Root<ElectricWaveUserRecord> root = query.from(ElectricWaveUserRecord.class);
//        query.groupBy(root.get("userId"));
//        query.multiselect(root.get("userId").alias("userId"), builder.count(root));
//        query.orderBy(builder.desc(builder.count(root)));
//        List<WaveNumber> result = entityManager.createQuery(query).getResultList();

        TimeUnit.SECONDS.sleep(1);
    }
}
