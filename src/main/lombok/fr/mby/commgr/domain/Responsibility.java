package fr.mby.commgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Responsibility extends AbstractHistoricalEntity {
	 
		@Column
	    private String name;

		@Column
	    private String note;

}
