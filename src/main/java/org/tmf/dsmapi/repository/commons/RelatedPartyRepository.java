package org.tmf.dsmapi.repository.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tmf.dsmapi.domain.commons.RelatedParty;

/**
 * Created by weizh on 2017-8-28.
 */
public interface RelatedPartyRepository extends JpaRepository<RelatedParty,Long>{
}
