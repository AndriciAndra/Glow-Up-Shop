package org.scrum.domain.repositories;

import org.scrum.domain.project.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query("select p from Item p where p.isDeleted = false and p.isActivated = true")
    List<Item> getAllItem();

    @Query("select p from Item p where p.category = ?1 and p.isActivated = true and p.isDeleted = false")
    List<Item> findAllByCategory(String category);
}
