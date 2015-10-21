package fr.mby.commgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

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
public class Person extends AbstractHistoricalEntity  {

	// Bidirectionnal make N+1 request https://hibernate.atlassian.net/browse/HHH-3930
	//@OneToOne(fetch=FetchType.LAZY, mappedBy = "person", optional = false)
	//private Account account;
	
	@Column
	private String lastName;
	
	@Column
	private String firstName;
	
	@Column
	private DateTime dateOfBirth;

	@Column
	private String address;
	
}
