package com.example.assignment5.repository;

import com.example.assignment5.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
//    Supplier getById(long id);
//    void deleteById(long id);

}
