package com.example.assignment8.service;


import com.example.assignment8.dao.SupplierRepository;
import com.example.assignment8.entity.Supplier;
import com.example.assignment8.exception.GoodsAdminException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public Supplier saveSupplier(Supplier supplier) throws GoodsAdminException {
        if (supplier.getId() != null) {
            if (supplierRepository.findById(supplier.getId()).isPresent()) {
                throw new GoodsAdminException("添加供应商失败：供应商已经存在");
            }
        }
        return supplierRepository.saveAndFlush(supplier);
    }

    public Supplier updateSupplier(long id, Supplier supplier) throws GoodsAdminException {
        if (!supplierRepository.findById(id).isPresent()) {
            throw new GoodsAdminException("修改供应商失败：供应商"+id+"不存在");
        }
        return supplierRepository.saveAndFlush(supplier);
    }

    public Page<Supplier> page(String name, Pageable pageable){
        return supplierRepository.findByNameContaining(name,pageable);
    }

    public Supplier getSupplierById(long id){
        return supplierRepository.findById(id).get();
    }

    public void deleteSupplierById(long id) {
        supplierRepository.deleteById(id);
    }
}
