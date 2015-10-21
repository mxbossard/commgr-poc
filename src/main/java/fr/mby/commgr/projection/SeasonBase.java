package fr.mby.commgr.projection;

import org.joda.time.DateTime;
import org.springframework.data.rest.core.config.Projection;

import fr.mby.commgr.domain.Season;

@Projection(name = "seasonBase", types = { Season.class }) 
public interface SeasonBase {

	String getName();

	DateTime getValidFrom();

	DateTime getValidTo();

	boolean isActive();

	String getNote();

}