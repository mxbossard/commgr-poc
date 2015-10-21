package fr.mby.commgr.projection;

import org.joda.time.DateTime;
import org.springframework.data.rest.core.config.Projection;

import fr.mby.commgr.domain.Account;

@Projection(name = "accountBase", types = { Account.class }) 
public interface AccountBase {

	String getUsername();

	String getUsernameCanonical();

	String getEmail();

	String getEmailCanonical();

	boolean isEnabled();

	String getPlainPassword();

	DateTime getLastLogin();

	String getConfirmationToken();

	DateTime getPasswordRequestedAt();

	boolean isLocked();

	boolean isExpired();

	DateTime getExpiresAt();

	boolean isCredentialsExpired();

	DateTime getCredentialsExpireAt();
	
}