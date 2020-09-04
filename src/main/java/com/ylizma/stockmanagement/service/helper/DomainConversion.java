package com.ylizma.stockmanagement.service.helper;

import com.ylizma.stockmanagement.domain.ProductDetails;
import com.ylizma.stockmanagement.domain.ProductGroupDetails;
import com.ylizma.stockmanagement.domain.SupplierDetails;
import com.ylizma.stockmanagement.domain.WareHouseDetails;
import com.ylizma.stockmanagement.model.Product;
import com.ylizma.stockmanagement.model.ProductGroup;
import com.ylizma.stockmanagement.model.Supplier;
import com.ylizma.stockmanagement.model.WareHouse;
import org.springframework.stereotype.Component;

@Component
public class DomainConversion {

    public ProductDetails convertProductToDetails(Product product) {

        return new ProductDetails().builder()
                .code(product.getCode())
                .description(product.getDescription())
                .name(product.getName())
                .minStock(product.getMinStock())
                .supplier(product.getSupplier())
                .productGroup(product.getProductGroup())
                .wareHouse(product.getWareHouse()).build();
    }

    public Product convertProductDetailsToProduct(ProductDetails productDetails) {

        return new Product().builder()
                .code(productDetails.getCode())
                .description(productDetails.getDescription())
                .name(productDetails.getName())
                .minStock(productDetails.getMinStock())
                .supplier(productDetails.getSupplier())
                .productGroup(productDetails.getProductGroup())
                .wareHouse(productDetails.getWareHouse()).build();
    }

    public ProductGroupDetails convertProductGroupToProductGroupDetails(ProductGroup productGroup) {
        return new ProductGroupDetails().builder()
                .active(productGroup.isActive())
                .code(productGroup.getCode())
                .name(productGroup.getName())
                .build();
    }

    public ProductGroup convertProductGroupDetailsToProduct(ProductGroupDetails productGroupDetails) {
        return new ProductGroup().builder()
                .active(productGroupDetails.isActive())
                .code(productGroupDetails.getCode())
                .name(productGroupDetails.getName())
                .build();
    }

    public SupplierDetails convertSupplierToSupplierDetails(Supplier supplier) {
        return new SupplierDetails().builder()
                .active(supplier.isActive())
                .address(supplier.getAddress())
                .city(supplier.getCity())
                .companyID(supplier.getCompanyID())
                .name(supplier.getName())
                .fax(supplier.getFax())
                .phone(supplier.getPhone())
                .id(supplier.getId())
                .build();
    }

    public Supplier convertSupplierDetailsToSupplier(SupplierDetails p) {
         return new Supplier().builder()
                .active(p.isActive())
                .address(p.getAddress())
                .city(p.getCity())
                .companyID(p.getCompanyID())
                .name(p.getName())
                .fax(p.getFax())
                .phone(p.getPhone())
                .build();
    }

    public WareHouseDetails convertWareHouseToWarehousedeatils(WareHouse wareHouse){
        return new WareHouseDetails().builder()
                .active(wareHouse.getActive())
                .description(wareHouse.getDescription())
                .name(wareHouse.getName())
                .id(wareHouse.getId()).build();
    }

      public WareHouse convertWareHouseDetailsToWarehouse(WareHouseDetails wareHouse){
        return new WareHouse().builder()
                .active(wareHouse.getActive())
                .description(wareHouse.getDescription())
                .name(wareHouse.getName())
                .id(wareHouse.getId()).build();
    }
}
