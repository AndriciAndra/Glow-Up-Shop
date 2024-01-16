package org.scrum.domain.repositories;

import org.scrum.domain.project.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByClient_Username(String username);
    @Modifying
    @Transactional
    @Query("update Cart p SET p.totalItems = 0, p.totalPrice = 0 where p.id = :id")
    void updateCartById(@Param("id") int id);
}
