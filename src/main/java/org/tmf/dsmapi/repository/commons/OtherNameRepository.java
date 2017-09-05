package org.tmf.dsmapi.repository.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tmf.dsmapi.domain.commons.OtherName;

import javax.xml.bind.JAXBPermission;

/**
 * Created by weizh on 2017-8-28.
 */
public interface OtherNameRepository extends JpaRepository<OtherName,Long> {
}
