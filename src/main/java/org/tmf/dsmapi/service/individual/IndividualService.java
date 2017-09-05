package org.tmf.dsmapi.service.individual;

import org.springframework.beans.factory.annotation.Autowired;
import org.tmf.dsmapi.domain.individual.Individual;
import org.tmf.dsmapi.repository.individual.IndividualRepository;

/**
 * Created by weizh on 2017-8-29.
 */
public interface IndividualService {

    Individual create(Individual individual);

    Individual update(Individual individual);

    Individual findById(Long id);

    Individual patch(Individual currentIndividual,Individual partialIndividual);

    void delete(long id);

}
