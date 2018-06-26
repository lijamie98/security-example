package com.javilet.vulner.jsoninjection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jamie on 3/30/17.
 */
@Configuration
public class ServerConfig {
    private static final Logger logger = LogManager.getLogger();

    @Bean
    WebServer webServer() {
        WebServer webServer = new WebServer();
        logger.info("Initializing web server");
        webServer.routes();

        return webServer;
    }
}
