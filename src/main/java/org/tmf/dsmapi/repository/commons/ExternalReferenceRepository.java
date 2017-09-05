package org.tmf.dsmapi.repository.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tmf.dsmapi.domain.commons.ExternalReference;

/**
 * Created by weizh on 2017-8-28.
 */
public interface ExternalReferenceRepository extends JpaRepository<ExternalReference,Long>{
}
