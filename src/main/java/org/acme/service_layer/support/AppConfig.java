package org.acme.service_layer.support;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * @author x80486
 */
@Default
public class AppConfig {
  // TODO: Working this out
  @Produces
  @ApplicationScoped
  @PersistenceUnit(unitName = "test")
  // @PersistenceContext(unitName = "test")
  private EntityManagerFactory factory;
}
