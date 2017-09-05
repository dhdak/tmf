package org.tmf.dsmapi.controller.individual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.ResourceNotFoundException;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.domain.individual.Disability;
import org.tmf.dsmapi.domain.individual.Individual;
import org.tmf.dsmapi.service.individual.IndividualService;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by weizh on 2017-8-29.
 */
@RestController
@RequestMapping(value = IndividualController.BASE_URL)
public class IndividualController {

    public static final String BASE_URL = "/api/partyManagement/v2/individual";

    @Autowired
    IndividualService individualService;

    /**
     * 创建Individual
     *
     * @param individual
     * @return
     * @throws BadUsageException
     * @throws UnknownResourceException
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Individual create(@RequestBody Individual individual) throws BadUsageException, UnknownResourceException {
        individual = individualService.create(individual);
        individual.setHref("href/".concat(Long.toString(individual.getId())));
        individual = individualService.update(individual);
//        publisher.createNotification(entity, new Date());
        return individual;
    }

    /**
     * 根据id查询Individual
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Individual get(@PathVariable long id) throws ResourceNotFoundException{
        Individual individual = individualService.findById(id);
        if (individual == null) {
            throw new ResourceNotFoundException("根据id" + id + "未找到资源");
        }
        List<Disability> disabilityList = individual.getDisability();
        System.out.println(disabilityList.get(0).getHjid());
        return individual;
    }

    /**
     * 以put方式根据id更新 Individual
     *
     * @param id
     * @param entity
     * @return
     * @throws UnknownResourceException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public Individual update(@PathVariable("id") long id, @RequestBody Individual entity) throws ResourceNotFoundException{
        Response response = null;
        Individual individual = individualService.findById(id);
        if (individual != null) {
            entity.setId(id);
            individual = individualService.update(entity);

        } else {
            throw new ResourceNotFoundException("根据id" + id + "未找到资源");
        }
        return individual;
    }

    /**
     * 以patch方式根据id更新 Individual
     *
     * @param id
     * @param partialIndividual
     * @return
     * @throws BadUsageException
     * @throws UnknownResourceException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = "application/json", produces = "application/json")
    public Individual patch(@PathVariable("id") long id, @RequestBody Individual partialIndividual) throws BadUsageException, ResourceNotFoundException {
        Individual currentIndividual = individualService.findById(id);
        if (currentIndividual == null) {
            throw new ResourceNotFoundException("根据id" + id + "未找到资源");
        }
        currentIndividual = individualService.patch(currentIndividual, partialIndividual);
        return currentIndividual;
    }

    /**
     * 根据id删除individual
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
        individualService.delete(id);
    }


}
