package org.liubov.ai_aggregator.repository;

import org.liubov.ai_aggregator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
