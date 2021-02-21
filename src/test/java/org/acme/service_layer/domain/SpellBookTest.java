package org.acme.service_layer.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * @author x80486
 */
final class SpellBookTest {
  @Test
  void add() {
    final var record = new SpellBook("the spell book");
    final var spell = new Spell("orc's spell");
    record.add(spell);
    Assertions.assertThat(record.getSpells()).containsExactly(spell);
    Assertions.assertThat(spell.getSpellBook()).isEqualTo(record);
  }

  //-----------------------------------------------------------------------------------------------
  //
  //-----------------------------------------------------------------------------------------------

  @Test
  void defaultInstance() {
    final var record = new SpellBook();
    Assertions.assertThat(record)
        .hasAllNullFieldsOrPropertiesExcept("spells", "wizards")
        .satisfies(it -> {
          Assertions.assertThat(it.getSpells()).isEmpty();
        });
  }

  @Test
  void instance() {
    final var record = new SpellBook("wizard name");
    Assertions.assertThat(record)
        .hasNoNullFieldsOrPropertiesExcept("id", "version")
        .satisfies(it -> {
          Assertions.assertThat(it.getName()).isEqualTo("wizard name");
          Assertions.assertThat(it.getSpells()).isEmpty();
        });
  }

  @Test
  void verifyHashCodeEqualsContract() {
    EqualsVerifier.forClass(SpellBook.class)
        .withIgnoredFields("spells", "version")
        .withPrefabValues(Spell.class, new Spell(), Mockito.mock(Spell.class))
        .verify();
  }
}
