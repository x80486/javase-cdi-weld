package org.acme.service_layer.support;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

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
