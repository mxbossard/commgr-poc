package fr.mby.commgr.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Account extends AbstractHistoricalEntity {

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name="fk_person", nullable = true)
	private Person person;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="account")
    private Set<Membership> memberships;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Privilege> privileges;

	@Column
    protected String username;

	@Column
    protected String usernameCanonical;

	@Column
    protected String email;

	@Column
    protected String emailCanonical;

	@Column
    protected boolean enabled;
    
    /**
     * The salt to use for hashing
     */
	@Column
	@JsonIgnore
    protected String salt;
    
    /**
     * Encrypted password. Must be persisted.
     */
	@Column
	@JsonIgnore
    protected String password;
    
    /**
     * Plain password. Used for model validation. Must not be persisted.
     */
	@JsonIgnore
    protected String plainPassword;

	@Column
    protected DateTime lastLogin;
	
    /**
     * Random string sent to the user email address in order to verify it
     */
	@Column
	@JsonIgnore
    protected String confirmationToken;

	@Column
    protected DateTime passwordRequestedAt;

	@Column
    protected boolean locked;

	@Column
    protected boolean expired;

	@Column
    protected DateTime expiresAt;

	@Column
    protected boolean credentialsExpired;

	@Column
    protected DateTime credentialsExpireAt;
    
    /**
     * @var Collection
     */
    //protected $groups;
    
    /**
     * @var array
     */
    //protected $roles;
    
	public Account() {
		super();
		
		this.salt = "";
        this.enabled = false;
        this.locked = false;
        this.expired = false;
        this.credentialsExpired = false;
      
        //this.roles = array();
	}

}
