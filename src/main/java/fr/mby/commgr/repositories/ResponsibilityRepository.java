package fr.mby.commgr.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.mby.commgr.domain.Responsibility;

@RepositoryRestResource
public interface ResponsibilityRepository extends ICommonRepository<Responsibility, Long> {

}
