package com.team2.inventory.service;

import com.team2.inventory.interfacemethods.StockUsageInventoryInterface;
import com.team2.inventory.repository.StockUsageInventoryRepository;
import com.team2.inventory.model.StockUsageInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StockUsageInventoryImplementation implements StockUsageInventoryInterface {

    @Autowired
    StockUsageInventoryRepository suirepo;

    @Override
    @Transactional
    public void saveStockUsageInventory(StockUsageInventory sui) {
        suirepo.save(sui);
    }

    @Override
    @Transactional
    public void deleteStockUsageInventory(StockUsageInventory sui) {
        suirepo.delete(sui);
    }

    @Override
    @Transactional
    public List<StockUsageInventory> listAllStockUsageInventories() {
        return suirepo.findAll();
    }

    @Override
    @Transactional
    public StockUsageInventory findStockUsageInventoryById(Integer id) {
        return suirepo.findById(id).get();
    }


}
