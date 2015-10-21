package fr.mby.commgr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.mby.commgr.domain.Account;
import fr.mby.commgr.projection.AccountInline;

@RepositoryRestResource(excerptProjection = AccountInline.class)
public interface AccountRepository extends ICommonRepository<Account, Long> {

	Account findByUsername(String username);
	
	//@Query("select a from Account a join fetch a.person join fetch a.privileges")
	//@EntityGraph(value = "Account.detail", type = EntityGraphType.LOAD)
	//Iterable<Account> findAll();
	
	//@Query("select a from Account a join fetch a.person")
	//Iterable<Account> findAll(Sort sort);

	//@Query(value="select a from Account a left join fetch a.person left join fetch a.privileges limit :pageable.pageSize offset :pageable.offset", countQuery="select count(a) from Account a")
	@EntityGraph(type = EntityGraphType.LOAD, attributePaths = {"person", "privileges"})
	Page<Account> findAll(Pageable pageable);
}
