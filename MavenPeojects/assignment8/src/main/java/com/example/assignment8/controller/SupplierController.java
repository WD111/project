package com.example.assignment8.controller;


import com.example.assignment8.entity.Supplier;
import com.example.assignment8.exception.GoodsAdminException;
import com.example.assignment8.service.SupplierService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplier(@ApiParam("供应商Id")@PathVariable long id){
        Supplier result = supplierService.getSupplierById(id);
        if(result==null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("")
    public Page<Supplier> page(@ApiParam("商品名称")String name,
                                       @ApiParam("页码")@RequestParam(defaultValue = "0")Integer pageNum,
                                       @ApiParam("每页记录数") @RequestParam(defaultValue = "10")Integer pageSize){
        return supplierService.page(name, PageRequest.of(pageNum,pageSize, Sort.by("id")));
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('/supplier/update')")
    public Supplier saveSupplier(@RequestBody Supplier supplier) throws GoodsAdminException {
            return supplierService.saveSupplier(supplier);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('/supplier/update')")
    public void updateSupplier(@PathVariable long id, @RequestBody Supplier supplier) throws GoodsAdminException {
        supplierService.updateSupplier(id,supplier);
    }

    @PreAuthorize("hasAuthority('/supplier/update')")
    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable long id){
        supplierService.deleteSupplierById(id);
    }

}
