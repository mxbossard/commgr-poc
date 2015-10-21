package fr.mby.commgr.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.mby.commgr.domain.Person;

@RepositoryRestResource
public interface PersonRepository extends ICommonRepository<Person, Long> {

	
}
