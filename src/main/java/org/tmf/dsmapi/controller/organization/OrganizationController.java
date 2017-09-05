package org.tmf.dsmapi.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tmf.dsmapi.commons.exceptions.ResourceNotFoundException;
import org.tmf.dsmapi.domain.organization.Organization;
import org.tmf.dsmapi.service.organization.OrganizationService;

/**
 * Created by weizh on 2017-9-1.
 */
@RestController
@RequestMapping(value = OrganizationController.BASE_URL)
public class OrganizationController {

    public static final String BASE_URL = "/api/partyManagement/v2/organization";

    @Autowired
    OrganizationService organizationService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Organization create(@RequestBody Organization organization) throws Exception {

        organization = organizationService.create(organization);
        organization.setHref("href/".concat(Long.toString(organization.getId())));
        organizationService.update(organization);
        return organization;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Organization get(@PathVariable("id")long id)throws Exception{
        Organization organization = organizationService.findById(id);
        return organization;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT,consumes = "application/json", produces = "application/json")
    public Organization update(@PathVariable("id")long id,@RequestBody Organization entity) throws Exception {
        Organization organization = organizationService.findById(id);
        if (organization != null) {
            entity.setId(id);
            entity = organizationService.update(entity);
        } else {
            // 404 not found
            throw new ResourceNotFoundException("根据id" + id + "未找到资源");
        }
        return entity;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PATCH,consumes = "application/json", produces = "application/json")
    public Organization patch(@PathVariable("id")long id,@RequestBody Organization partialOrganization) throws Exception {

        Organization currentOrganization = organizationService.findById(id);
        if (currentOrganization == null) {
            throw new ResourceNotFoundException("根据id" + id + "未找到资源");
        }
        currentOrganization = organizationService.patch(currentOrganization, partialOrganization);
        return currentOrganization;
    }
}
