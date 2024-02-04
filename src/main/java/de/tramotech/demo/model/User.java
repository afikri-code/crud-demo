package de.tramotech.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity{

  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "email", nullable = false)
  @Email(message = "Email is not valid")
  private String email;
  @Embedded
  @Delegate
  @Setter(AccessLevel.NONE)
  @Getter(AccessLevel.NONE)
  private EntityMetaInfo metaInfo = new EntityMetaInfo();

  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private List<Project> projects ;
}
