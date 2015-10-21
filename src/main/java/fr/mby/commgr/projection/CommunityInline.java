package fr.mby.commgr.projection;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import fr.mby.commgr.domain.Community;
import fr.mby.commgr.domain.Season;

@Projection(name = "communityInline", types = { Community.class })
public interface CommunityInline extends CommunityBase {
	
	Set<Season> getSeasons();
	
}
