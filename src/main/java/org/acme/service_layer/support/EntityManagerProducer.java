package org.acme.service_layer.support;

import jakarta.enterprise.inject.Produces;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

/**
 * @author ɐɹǝʌ ɯıpɐʌ
 */
public class EntityManagerProducer {
  @Produces
  // @ApplicationScoped
  // @PersistenceUnit(unitName = "test")
  @PersistenceContext(unitName = "test")
  private EntityManagerFactory factory;
}
