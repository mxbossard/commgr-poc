package fr.mby.commgr.projection;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import fr.mby.commgr.domain.Account;
import fr.mby.commgr.domain.Person;
import fr.mby.commgr.domain.Privilege;

@Projection(name = "accountInline", types = { Account.class }) 
public interface AccountInline extends AccountBase {

	Person getPerson();
	
	Set<Privilege> getPrivileges();
	
}