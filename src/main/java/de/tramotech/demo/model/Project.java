package de.tramotech.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;

import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class Project extends BaseEntity{

  private String name;
  private String description;
  @Column(name = "user_id")
  private long userId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  private User author;

  @Embedded
  @Delegate
  @Setter(AccessLevel.NONE)
  @Getter(AccessLevel.NONE)
  private EntityMetaInfo metaInfo = new EntityMetaInfo();

  @ManyToMany(cascade = {CascadeType.PERSIST})
  @JoinTable(
    name = "project_images",
    joinColumns = @JoinColumn(name = "project_id"),
    inverseJoinColumns = @JoinColumn(name = "image_id")
  )
  private Set<Image> images = new HashSet<>();
}
