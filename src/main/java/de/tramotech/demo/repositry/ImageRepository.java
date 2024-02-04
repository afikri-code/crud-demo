package de.tramotech.demo.repositry;

import de.tramotech.demo.model.Image;
import de.tramotech.demo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
