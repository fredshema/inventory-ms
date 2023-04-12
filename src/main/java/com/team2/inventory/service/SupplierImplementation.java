package com.team2.inventory.service;

import com.team2.inventory.interfacemethods.SupplierInterface;
import com.team2.inventory.repository.SupplierRepository;
import com.team2.inventory.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplierImplementation implements SupplierInterface {
    @Autowired
    SupplierRepository srepo;

    public Page<Supplier> listAllSuppliers(int pageNumber,String sortField,String sortDir) {
    	Sort sort=Sort.by(sortField);
		sort=sortDir.equals("asc")?sort.ascending():sort.descending();
        Pageable pageable= PageRequest.of(pageNumber - 1, 5,sort);
        return srepo.findAll(pageable);
    }

    @Override
    public void createSupplier(Supplier supplier) {
        srepo.save(supplier);
    }

    @Override
    @Transactional
    public Supplier findSupplierById(Integer id) {
        return srepo.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteSupplier(Supplier member) {
        srepo.delete(member);
    }

    @Override
    public List<Supplier> listAllSuppliers() {
        return srepo.findAll();
    }
    
    @Override
    public Supplier findSupplierByName (String name) {
    	return srepo.findSupplierByName(name);
    }
}