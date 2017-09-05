package org.tmf.dsmapi.repository.hun;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tmf.dsmapi.domain.hub.Hub;

/**
 * Created by weizh on 2017-8-28.
 */
public interface HubRepository extends JpaRepository<Hub,String> {
}
