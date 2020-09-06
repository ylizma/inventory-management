package com.ylizma.stockmanagement.service.helper;

import com.ylizma.stockmanagement.domain.*;
import com.ylizma.stockmanagement.model.*;
import org.springframework.stereotype.Component;

@Component
public class DomainConversion {

    public ProductDetails convertProductToDetails(Product product) {

        return ProductDetails.builder()
                .id(product.getId())
                .code(product.getCode())
                .description(product.getDescription())
                .name(product.getName())
                .minStock(product.getMinStock())
                .supplier(convertSupplierToSupplierDetails(product.getSupplier()))
                .productGroup(convertProductGroupToProductGroupDetails(product.getProductGroup()))
                .wareHouse(convertWareHouseToWarehousedeatils(product.getWareHouse()))
                .quantity(product.getQuantity())
                .build();
    }

    public Product convertProductDetailsToProduct(ProductDetails productDetails) {

        return Product.builder()
                .code(productDetails.getCode())
                .description(productDetails.getDescription())
                .name(productDetails.getName())
                .minStock(productDetails.getMinStock())
                .supplier(convertSupplierDetailsToSupplier(productDetails.getSupplier()))
                .productGroup(convertProductGroupDetailsToProduct(productDetails.getProductGroup()))
                .wareHouse(convertWareHouseDetailsToWarehouse(productDetails.getWareHouse()))
                .quantity(productDetails.getQuantity())
                .build();
    }

    public ProductGroupDetails convertProductGroupToProductGroupDetails(ProductGroup productGroup) {
        return ProductGroupDetails.builder()
                .active(productGroup.isActive())
                .code(productGroup.getCode())
                .name(productGroup.getName())
                .id(productGroup.getId())
                .build();
    }

    public ProductGroup convertProductGroupDetailsToProduct(ProductGroupDetails productGroupDetails) {
        return ProductGroup.builder()
                .active(productGroupDetails.isActive())
                .code(productGroupDetails.getCode())
                .name(productGroupDetails.getName())
                .build();
    }

    public SupplierDetails convertSupplierToSupplierDetails(Supplier supplier) {
        return SupplierDetails.builder()
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
        return Supplier.builder()
                .active(p.isActive())
                .address(p.getAddress())
                .city(p.getCity())
                .companyID(p.getCompanyID())
                .name(p.getName())
                .fax(p.getFax())
                .phone(p.getPhone())
                .build();
    }

    public WareHouseDetails convertWareHouseToWarehousedeatils(WareHouse wareHouse) {
        return WareHouseDetails.builder()
                .active(wareHouse.getActive())
                .description(wareHouse.getDescription())
                .name(wareHouse.getName())
                .id(wareHouse.getId()).build();
    }

    public WareHouse convertWareHouseDetailsToWarehouse(WareHouseDetails wareHouse) {
        return WareHouse.builder()
                .active(wareHouse.getActive())
                .description(wareHouse.getDescription())
                .name(wareHouse.getName())
                .build();
    }

    public StockMovementDetails convertStockMtoStockMdetails(StockMovement stockMovement) {
        return StockMovementDetails.builder()
                .createdAt(stockMovement.getCreatedAt())
                .description(stockMovement.getDescription())
                .id(stockMovement.getId())
                .lastModified(stockMovement.getLastModified())
                .movementType(stockMovement.getMovementType())
                .product(stockMovement.getProduct())
                .quantity(stockMovement.getQuantity())
                .build();
    }

    public StockMovement convertStockMDetailstoStockM(StockMovementDetails stockMovement) {
        return StockMovement.builder()
                .description(stockMovement.getDescription())
                .id(stockMovement.getId())
                .movementType(stockMovement.getMovementType())
                .product(stockMovement.getProduct())
                .quantity(stockMovement.getQuantity())
                .build();
    }
}
