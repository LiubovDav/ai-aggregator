package org.liubov.ai_aggregator.repository;

import org.liubov.ai_aggregator.model.ImageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRequestRepository extends JpaRepository<ImageRequest, Integer> {
}
