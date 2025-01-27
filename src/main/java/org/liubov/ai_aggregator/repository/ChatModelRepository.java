package org.liubov.ai_aggregator.repository;

import org.liubov.ai_aggregator.model.ChatModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatModelRepository extends JpaRepository<ChatModel, Integer> {
}
