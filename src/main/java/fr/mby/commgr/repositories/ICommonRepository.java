package fr.mby.commgr.repositories;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface ICommonRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

}
