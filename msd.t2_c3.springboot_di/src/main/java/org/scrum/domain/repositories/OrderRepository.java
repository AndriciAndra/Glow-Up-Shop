package org.scrum.domain.repositories;

import org.scrum.domain.project.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select p from Order p where p.clientId.client_id = :id")
    List<Order> getAllOrdersByClientId(@Param("id") int id);
}
