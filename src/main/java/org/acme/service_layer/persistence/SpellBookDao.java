package org.acme.service_layer.persistence;

import jakarta.inject.Singleton;
import lombok.extern.log4j.Log4j2;
import org.acme.service_layer.domain.SpellBook;

import java.util.Optional;

/**
 * @author x80486
 */
@Log4j2
@Singleton
public class SpellBookDao extends AbstractDao<SpellBook> {
  public Optional<SpellBook> findByName(final String name) {
    logger.debug("Searching spell book with name [{}]...", name);
    final var builder = entityManager.getCriteriaBuilder();
    final var criteria = builder.createQuery(type);
    final var model = criteria.from(type);
    criteria.select(model).where(builder.equal(model.get("name"), name));
    return Optional.ofNullable(entityManager.createQuery(criteria.select(model)).getSingleResult());
  }
}
