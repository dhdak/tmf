package org.tmf.dsmapi.repository.individual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tmf.dsmapi.domain.individual.Disability;

/**
 * Created by weizh on 2017-8-28.
 */
public interface DisabilityRepository extends JpaRepository<Disability,Long>{
}
