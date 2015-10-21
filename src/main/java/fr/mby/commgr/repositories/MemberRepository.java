package fr.mby.commgr.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.mby.commgr.domain.Member;

@RepositoryRestResource
public interface MemberRepository extends ICommonRepository<Member, Long> {
	
}
