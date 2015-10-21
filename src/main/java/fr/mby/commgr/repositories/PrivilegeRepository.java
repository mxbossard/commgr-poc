package fr.mby.commgr.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.mby.commgr.domain.Privilege;

@RepositoryRestResource
public interface PrivilegeRepository extends ICommonRepository<Privilege, Long> {

}
