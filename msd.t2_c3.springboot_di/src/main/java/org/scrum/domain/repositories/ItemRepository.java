package org.scrum.domain.repositories;

import org.scrum.domain.project.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query("select p from Item p where p.is_deleted = false and p.is_activated = true")
    List<Item> getAllItem();
}
