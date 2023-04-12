package com.team2.inventory.repository;

import com.team2.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    public Inventory findInventoryById(int id);
}
