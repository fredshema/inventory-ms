package com.team2.inventory.interfacemethods;

import com.team2.inventory.model.Supplier;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierInterface {

    public List<Supplier> listAllSuppliers();
    public void createSupplier(Supplier supplier);
    public Supplier findSupplierById(Integer id);
    public void deleteSupplier(Supplier supplier);
    public Page<Supplier> listAllSuppliers(int pageNumber,String sortField,String sortDir);
    public Supplier findSupplierByName (String name);
}
