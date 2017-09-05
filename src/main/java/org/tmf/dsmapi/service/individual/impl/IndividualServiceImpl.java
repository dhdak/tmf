package org.tmf.dsmapi.service.individual.impl;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tmf.dsmapi.commons.utils.BeanUtils;
import org.tmf.dsmapi.domain.individual.Individual;
import org.tmf.dsmapi.repository.individual.IndividualRepository;
import org.tmf.dsmapi.service.individual.IndividualService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

/**
 * Created by weizh on 2017-8-29.
 */
@Service
public class IndividualServiceImpl implements IndividualService {

    @Autowired
    IndividualRepository individualRepository;


    public Individual create(Individual individual){
        return individualRepository.save(individual);
    }

    public Individual update(Individual individual){
        return individualRepository.save(individual);
    }

    public Individual findById(Long id){
        Individual individual = individualRepository.findById(id);
//        System.out.println(individual.getDisability().get(0).getHjid());
        return individual;
    }

    @Transactional
    public Individual patch(Individual currentIndividual,Individual partialIndividual){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(partialIndividual, JsonNode.class);
        if (BeanUtils.patch(currentIndividual, partialIndividual, node)) {
            currentIndividual = individualRepository.save(currentIndividual);
        }
        return currentIndividual;
    }

    public void delete(long id){
        individualRepository.delete(id);
    }

}
