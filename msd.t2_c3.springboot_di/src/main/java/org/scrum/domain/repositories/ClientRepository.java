package org.scrum.domain.repositories;

import org.scrum.domain.project.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByUsername(String username);
}
