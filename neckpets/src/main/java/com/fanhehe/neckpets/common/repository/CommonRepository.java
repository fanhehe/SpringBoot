package com.fanhehe.neckpets.common.repository;

import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/14 20:57
 */
@NoRepositoryBean
public interface CommonRepository<T> extends BaseRepository<T, Long> {
}
