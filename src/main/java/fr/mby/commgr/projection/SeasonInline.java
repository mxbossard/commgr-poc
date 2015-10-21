package fr.mby.commgr.projection;

import org.springframework.data.rest.core.config.Projection;

import fr.mby.commgr.domain.Community;
import fr.mby.commgr.domain.Season;

@Projection(name = "seasonInline", types = { Season.class }) 
public interface SeasonInline extends SeasonBase {

	Community getCommunity(); 
  
}