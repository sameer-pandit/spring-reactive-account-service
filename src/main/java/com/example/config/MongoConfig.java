package com.example.config;

import com.example.account.AccountRepository;
import com.example.customer.CustomerRepository;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.support.SimpleReactiveMongoRepository;
import org.springframework.data.repository.query.DefaultEvaluationContextProvider;
import org.springframework.data.mongodb.repository.support.ReactiveMongoRepositoryFactory;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.BeansException;

/**
 * Created by pranjal on 10/4/16.
 */

@Configuration
public class MongoConfig implements BeanClassLoaderAware, BeanFactoryAware {

//  public @Bean MongoDbFactory mongoDbFactory() throws Exception {
//    //UserCredentials userCredentials = new UserCredentials("joe", "secret");
//    return new SimpleMongoDbFactory(new Mongo(), "database");
//  }
//
//  public @Bean MongoTemplate mongoTemplate() throws Exception {
//    return new MongoTemplate(mongoDbFactory());
//  }

  private ClassLoader classLoader;
  private BeanFactory beanFactory;

  @Bean
  MongoClient mongoClient() {
    return MongoClients.create();
  }

  @Bean
  ReactiveMongoDatabaseFactory reactiveMongoDbFactory(MongoClient mongoClient){
    return new SimpleReactiveMongoDatabaseFactory(mongoClient, "database");
  }

  @Bean
  ReactiveMongoTemplate reactiveMongoTemplate(ReactiveMongoDatabaseFactory mongoDbFactory){
    return new ReactiveMongoTemplate(mongoDbFactory);
  }

  @Bean
  ReactiveMongoRepositoryFactory reactiveMongoRepositoryFactory(ReactiveMongoOperations reactiveMongoOperations){

    ReactiveMongoRepositoryFactory factory = new ReactiveMongoRepositoryFactory(reactiveMongoOperations);
    factory.setRepositoryBaseClass(SimpleReactiveMongoRepository.class);
    factory.setBeanClassLoader(classLoader);
    factory.setBeanFactory(beanFactory);
    factory.setEvaluationContextProvider(DefaultEvaluationContextProvider.INSTANCE);

    return factory;
  }

  @Bean
  AccountRepository accountRepository(ReactiveMongoRepositoryFactory factory){
    return factory.getRepository(AccountRepository.class);
  }

  @Bean
  CustomerRepository customerRepository(ReactiveMongoRepositoryFactory factory){
    return factory.getRepository(CustomerRepository.class);
  }

  @Override
  public void setBeanClassLoader(ClassLoader classLoader) {
    this.classLoader = classLoader;
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
  }


}
