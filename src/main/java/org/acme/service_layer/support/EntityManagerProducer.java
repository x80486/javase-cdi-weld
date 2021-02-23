package org.acme.service_layer.support;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author x80486
 */
@ApplicationScoped
public class EntityManagerProducer {
  @Inject
  private EntityManagerFactory entityManagerFactory;

  public void close(@Disposes final EntityManager entityManager) {
    entityManager.close();
  }

  @Produces
  @RequestScoped
  public EntityManager create() {
    return entityManagerFactory.createEntityManager();
  }
}
