package de.tramotech.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="images")
@Data
public class Image extends BaseEntity{
  private String url;

  @ManyToMany(mappedBy = "images")
  private List<Project> projects = new ArrayList<>();
}
