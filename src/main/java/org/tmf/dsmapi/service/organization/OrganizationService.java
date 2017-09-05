package org.tmf.dsmapi.service.organization;

import org.tmf.dsmapi.domain.organization.Organization;

/**
 * Created by weizh on 2017-9-4.
 */
public interface OrganizationService {

    Organization create(Organization organization) throws Exception;

    Organization update(Organization organization) throws Exception;

    Organization findById(long id) throws Exception;

    Organization patch(Organization currentOrganization,Organization partialOrganization);

}
