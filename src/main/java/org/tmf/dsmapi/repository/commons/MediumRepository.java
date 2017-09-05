package org.tmf.dsmapi.repository.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tmf.dsmapi.domain.commons.Medium;

/**
 * Created by weizh on 2017-8-28.
 */
public interface MediumRepository extends JpaRepository<Medium,Long>{
}
