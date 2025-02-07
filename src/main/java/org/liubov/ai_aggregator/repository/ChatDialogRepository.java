package org.liubov.ai_aggregator.repository;

import org.liubov.ai_aggregator.model.ChatDialog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatDialogRepository extends JpaRepository<ChatDialog, Long> {
}
