package org.acme.service_layer.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * @author x80486
 */
@MappedSuperclass
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractPersistable implements Serializable {
  private static final long serialVersionUID = -4741049248831106966L;

  @Getter
  @Version
  @Column(name = "version")
  private Long version;
}
