package fr.mby.commgr.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.joda.time.DateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Season extends AbstractHistoricalEntity {
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@Fetch(FetchMode.JOIN)
	private Community community;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="season")
	private Set<Membership> memberships;

	@Column
	private String name;
	
	@Column
	private DateTime validFrom;
	
	@Column
	private DateTime validTo;
	
	@Column
	private boolean active;
	
	@Column(length=1024)
	private String note;

}
