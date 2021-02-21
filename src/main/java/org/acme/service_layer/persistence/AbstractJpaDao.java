package org.acme.service_layer.persistence;

import jakarta.inject.Inject;
import lombok.extern.log4j.Log4j2;
import org.acme.service_layer.domain.AbstractPersistable;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author x80486
 */
@Log4j2
public abstract class AbstractJpaDao<T extends AbstractPersistable> {
  @Inject
  protected EntityManager entityManager;

  protected Class<T> clazz;

  public void setClazz(final Class<T> clazz) {
    this.clazz = clazz;
  }

  //-----------------------------------------------------------------------------------------------
  //
  //-----------------------------------------------------------------------------------------------

  public void create(final T entity) {
    logger.debug("Persisting entity...");
    entityManager.persist(entity);
  }

  public void delete(final T entity) {
    logger.debug("Removing entity...");
    entityManager.remove(entity);
  }

  public List<T> findAll() {
    logger.debug("Retrieving all entities (this may take a while)...");
    final var builder = entityManager.getCriteriaBuilder();
    final var criteria = builder.createQuery(clazz);
    final var model = criteria.from(clazz);
    return entityManager.createQuery(criteria.select(model)).getResultList();
  }

  public T findOne(final long id) {
    logger.debug("Retrieving entity [{}]...", id);
    return entityManager.find(clazz, id);
  }

  public T update(final T entity) {
    logger.debug("Updating entity...");
    return entityManager.merge(entity);
  }
}
