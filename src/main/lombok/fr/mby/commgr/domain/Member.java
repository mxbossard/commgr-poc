package fr.mby.commgr.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Member extends AbstractHistoricalEntity  {

//	@OneToOne(fetch=FetchType.EAGER, mappedBy="member", optional=false)
//	@Fetch(FetchMode.JOIN)
//	private Account account;
//
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="member")
//    private Set<Membership> memberships;

}
