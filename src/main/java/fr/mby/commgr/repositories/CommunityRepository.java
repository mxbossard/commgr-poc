package fr.mby.commgr.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.mby.commgr.domain.Community;
import fr.mby.commgr.projection.CommunityInline;

@RepositoryRestResource(excerptProjection = CommunityInline.class)
public interface CommunityRepository extends ICommonRepository<Community, Long> {

    List<Community> findByName(String lastName);
    
	@EntityGraph(type = EntityGraphType.LOAD, attributePaths = {"seasons"})
	Page<Community> findAll(Pageable pageable);
	
}
