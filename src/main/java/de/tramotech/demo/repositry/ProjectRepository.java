package de.tramotech.demo.repositry;

import de.tramotech.demo.model.Project;
import de.tramotech.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
