package org.acme.service_layer.support;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;

/**
 * @author x80486
 */
@ApplicationScoped
public class EntityManagerFactoryProducer {
  public void close(@Disposes final EntityManagerFactory entityManagerFactory) {
    entityManagerFactory.close();
  }

  @Produces
  public EntityManagerFactory create() {
    return Persistence.createEntityManagerFactory("test", Collections.emptyMap());
  }
}
