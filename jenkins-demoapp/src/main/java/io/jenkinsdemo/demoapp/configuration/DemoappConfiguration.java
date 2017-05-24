package io.jenkinsdemo.demoapp.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jenkinsdemo.demoapp.resource.DemoappResourceImpl;

/**
 * Spring configuration of the Client API module.
 */
@Configuration
public class DemoappConfiguration {

	private static final Logger LOGGER = LogManager.getLogger(DemoappConfiguration.class);
	
    /**
     * The root resource of the API.
     * 
     * @return a {@link DemoappResourceImpl} instance
     */
    @Bean
    public DemoappResourceImpl createRootResource() {
    	LOGGER.debug("APP STARTED");
        return new DemoappResourceImpl();
    }
}
