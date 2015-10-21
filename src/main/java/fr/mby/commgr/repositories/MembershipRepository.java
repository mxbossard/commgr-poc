package fr.mby.commgr.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.mby.commgr.domain.Membership;

@RepositoryRestResource
public interface MembershipRepository extends ICommonRepository<Membership, Long> {

}
