package fr.mby.commgr.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.mby.commgr.domain.Season;
import fr.mby.commgr.projection.SeasonInline;

@RepositoryRestResource(excerptProjection = SeasonInline.class)
public interface SeasonRepository extends ICommonRepository<Season, Long> {

}
