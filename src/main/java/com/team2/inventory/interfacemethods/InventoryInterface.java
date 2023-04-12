package com.team2.inventory.interfacemethods;

import com.team2.inventory.model.Inventory;

import java.util.List;

public interface InventoryInterface {
    public boolean saveInventory(Inventory inventory);
    public List<Inventory> findAllInventorys();
    public Inventory findInventoryById(Integer id);
    public void deleteInventory(Inventory inventory);

}
