package com.team2.inventory.interfacemethods;

import com.team2.inventory.model.StockUsageInventory;

import java.util.List;

public interface StockUsageInventoryInterface {
    public void saveStockUsageInventory(StockUsageInventory sui);
    public void deleteStockUsageInventory(StockUsageInventory sui);
    public List<StockUsageInventory> listAllStockUsageInventories();
    public StockUsageInventory findStockUsageInventoryById(Integer id);
}
