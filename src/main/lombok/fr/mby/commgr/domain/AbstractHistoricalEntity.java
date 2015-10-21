package fr.mby.commgr.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.joda.time.DateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public abstract class AbstractHistoricalEntity {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @Column
    private DateTime createdAt;
    
    @Column
    private DateTime updatedAt;

    @PrePersist
    protected void onCreate() {
    	createdAt = new DateTime();
    }

    @PreUpdate
    protected void onUpdate() {
    	updatedAt = new DateTime();
    }
    
}
