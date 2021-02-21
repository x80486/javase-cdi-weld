package org.acme.service_layer.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @author x80486
 */
@Entity
@Getter
@Table(name = "spells")
@EqualsAndHashCode(callSuper = false, exclude = { "id", "spellBook", })
public final class Spell extends AbstractPersistable {
  private static final long serialVersionUID = 2545319800318144346L;

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Setter
  @ManyToOne
  @JoinColumn(name = "spell_book_id_fk", referencedColumnName = "id")
  private SpellBook spellBook;

  public Spell() { } // No-args constructor required by JPA

  public Spell(final String name) {
    this();
    this.name = name;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("name", name)
        .append("spellBook", spellBook)
        .toString();
  }
}
