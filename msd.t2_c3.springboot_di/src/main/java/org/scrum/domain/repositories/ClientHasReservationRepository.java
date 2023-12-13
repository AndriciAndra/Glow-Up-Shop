package org.scrum.domain.repositories;

import org.scrum.domain.project.ClientHasReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientHasReservationRepository extends JpaRepository<ClientHasReservation, Integer> {
}
