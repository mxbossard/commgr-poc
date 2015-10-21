package fr.mby.commgr.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Community extends AbstractHistoricalEntity {
	
	@OneToMany(fetch= FetchType.LAZY, mappedBy="community", cascade=CascadeType.ALL)
	private Set<Season> seasons;
	
	@OneToMany(fetch=FetchType.LAZY)
	private Set<Privilege> privileges;
	
	@Column
	private String name;
	
	@Column(length=1024)
	private String description;
	
	@Column
	private String email;
	
	@Column(length=1024)
	private String note;
	
	@Column
	private boolean joinable;
	
	@Column
	private boolean hidden;

}
