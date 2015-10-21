package fr.mby.commgr.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

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
public class Membership extends AbstractHistoricalEntity {
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@Fetch(FetchMode.JOIN)
	private Account account;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@Fetch(FetchMode.JOIN)
	private Season season;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	private Set<Responsibility> responsibilities;
	
	@Column
	private DateTime validFrom;
	
	@Column
	private DateTime validTo;
	
	@Column
	private boolean active;
	
	@Column(length=1024)
	private String note;

}
