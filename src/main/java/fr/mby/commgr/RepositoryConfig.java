package fr.mby.commgr;

import java.util.Set;

import javax.persistence.Entity;

import org.reflections.Reflections;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RepositoryConfig extends RepositoryRestMvcConfiguration {
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    	// Expose Ids for all entities in domain package.
    	Reflections reflections = new Reflections("fr.mby.commgr.domain");
    	Set<Class<?>> domainEntityClasses = reflections.getTypesAnnotatedWith(Entity.class);
        
    	domainEntityClasses.stream().forEach((clazz) -> config.exposeIdsFor(clazz));
    }
}