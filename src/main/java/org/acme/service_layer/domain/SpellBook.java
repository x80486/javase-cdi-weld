package org.acme.service_layer.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author x80486
 */
@Getter
@Entity
@Table(name = "spell_books")
@EqualsAndHashCode(callSuper = false, exclude = { "id", "spells", })
public class SpellBook extends AbstractPersistable {
  private static final long serialVersionUID = -5018345084134989900L;

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "spellBook", fetch = FetchType.LAZY)
  private List<Spell> spells;

  public SpellBook() { // No-args constructor required by JPA
    spells = new LinkedList<>();
  }

  public SpellBook(final String name) {
    this();
    this.name = name;
  }

  public void add(final Spell spell) {
    spell.setSpellBook(this);
    spells.add(spell);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("name", name)
        .append("spells", spells)
        .toString();
  }
}
