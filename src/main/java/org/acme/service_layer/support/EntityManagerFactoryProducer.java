package org.acme.service_layer.support;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
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
  @ApplicationScoped
  public EntityManagerFactory create() {
    return Persistence.createEntityManagerFactory("test", Collections.emptyMap());
  }
}
