package fr.mby.commgr;

import java.util.Set;

import org.reflections.Reflections;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class CustomizedRestMvcConfiguration extends RepositoryRestMvcConfiguration {

	@Override
	public RepositoryRestConfiguration config() {
		RepositoryRestConfiguration config = super.config();
		
    	// Add projection classes in package fr.mby.commgr.projection.
    	Reflections reflections = new Reflections("fr.mby.commgr.projection");
    	Set<Class<?>> projectionEntityClasses = reflections.getTypesAnnotatedWith(Projection.class);
    	projectionEntityClasses.stream().forEach((clazz) -> config.projectionConfiguration().addProjection(clazz));
    	
		return config;
	}

	@Override
	protected void configureJacksonObjectMapper(ObjectMapper objectMapper) {
		super.configureJacksonObjectMapper(objectMapper);
	}
	
	
}