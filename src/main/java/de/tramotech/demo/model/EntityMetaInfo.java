package de.tramotech.demo.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static java.time.LocalDate.now;

@Data
@Embeddable
public class EntityMetaInfo {
  @Setter(AccessLevel.NONE)
  private LocalDate createdAt;
  @Setter(AccessLevel.NONE)
  private LocalDate updatedAt;

  @PrePersist
  private void setCreatedAt(){
    this.createdAt = now();
  }

  @PostUpdate
  private void setUpdatedAt(){
    this.updatedAt = now();
  }
}
