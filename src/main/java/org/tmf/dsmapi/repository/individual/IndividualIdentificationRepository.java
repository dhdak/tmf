package org.tmf.dsmapi.repository.individual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tmf.dsmapi.domain.individual.IndividualIdentification;

/**
 * Created by weizh on 2017-8-28.
 */
public interface IndividualIdentificationRepository extends JpaRepository<IndividualIdentification,Long> {
}
