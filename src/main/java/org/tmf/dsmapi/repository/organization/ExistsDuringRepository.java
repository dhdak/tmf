package org.tmf.dsmapi.repository.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tmf.dsmapi.domain.organization.ExistsDuring;

/**
 * Created by weizh on 2017-8-29.
 */
public interface ExistsDuringRepository extends JpaRepository<ExistsDuring,Long>{
}
