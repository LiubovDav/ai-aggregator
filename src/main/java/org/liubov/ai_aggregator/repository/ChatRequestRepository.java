package org.liubov.ai_aggregator.repository;

import org.liubov.ai_aggregator.model.ChatRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRequestRepository extends JpaRepository<ChatRequest, Long> {
}
