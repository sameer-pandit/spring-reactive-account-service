package com.example.config;

import com.mongodb.Mongo;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.*;

/**
 * Created by pranjal on 10/4/16.
 */

@Configuration
public class AppConfig {

  public @Bean Mongo mongo() throws Exception {
    return new Mongo("localhost");
  }

}
