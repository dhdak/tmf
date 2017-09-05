package org.tmf.dsmapi.service.organization.impl;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.ExceptionType;
import org.tmf.dsmapi.commons.exceptions.ResourceNotFoundException;
import org.tmf.dsmapi.commons.utils.BeanUtils;
import org.tmf.dsmapi.domain.individual.Individual;
import org.tmf.dsmapi.domain.organization.Organization;
import org.tmf.dsmapi.repository.organization.OrganizationRepository;
import org.tmf.dsmapi.service.organization.OrganizationService;

/**
 * Created by weizh on 2017-9-4.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public Organization create(Organization organization) throws Exception {
        if (organization.getId() != null) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC, "While creating Organization, id must be null");
        }
        return organizationRepository.save(organization);
    }
    @Override
    public Organization update(Organization organization) throws Exception{
        if (organization.getId() == null) {
            throw new ResourceNotFoundException("根据id" + organization.getId() + "未找到资源");
        }
        return organizationRepository.save(organization);

    }

    @Override
    public Organization findById(long id) throws Exception{
        Organization organization = organizationRepository.findById(id);
        if(organization == null){
            throw new ResourceNotFoundException("根据id" + id + "未找到资源");
        }
        return organization;
    }

    @Transactional
    @Override
    public Organization patch(Organization currentOrganization, Organization partialOrganization){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(partialOrganization, JsonNode.class);
        if (BeanUtils.patch(currentOrganization, partialOrganization, node)) {
            currentOrganization = organizationRepository.save(currentOrganization);
        }
        return currentOrganization;
    }
}
