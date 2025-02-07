package org.liubov.ai_aggregator.repository;

import org.liubov.ai_aggregator.model.ChatResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatResponseRepository extends JpaRepository<ChatResponse, Long> {
}
