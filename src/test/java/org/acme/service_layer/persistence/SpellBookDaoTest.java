package org.acme.service_layer.persistence;

import org.assertj.core.api.Assertions;
import org.jboss.weld.junit5.EnableWeld;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.UUID;

@EnableWeld
final class SpellBookDaoTest {
  @Inject
  private SpellBookDao dao;

  @Test
  void findByName_WhenSpellBookExists() {
    final var optional = dao.findByName("The Dark Lord Ascending");
    Assertions.assertThat(optional)
        .hasValueSatisfying(it -> {
          Assertions.assertThat(it.getId()).isEqualTo(UUID.fromString("715811c9-ae11-41ec-8652-671fd88cd2a0"));
          Assertions.assertThat(it.getName()).isEqualTo("The Dark Lord Ascending");
          Assertions.assertThat(it.getSpells()).isEmpty();
          // ...
          Assertions.assertThat(it.getVersion()).isEqualTo(0L);
        });
  }
}
