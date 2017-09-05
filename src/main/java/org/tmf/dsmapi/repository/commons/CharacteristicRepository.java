package org.tmf.dsmapi.repository.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tmf.dsmapi.domain.commons.Characteristic;

/**
 * Created by weizh on 2017-8-28.
 */
public interface CharacteristicRepository extends JpaRepository<Characteristic,Long>{
}
