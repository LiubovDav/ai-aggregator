package org.liubov.ai_aggregator.repository;

import org.liubov.ai_aggregator.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageModelRepository extends JpaRepository<ImageModel, Integer> {
}
