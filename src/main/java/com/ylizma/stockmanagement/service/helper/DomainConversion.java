package com.ylizma.stockmanagement.service.helper;

import com.ylizma.stockmanagement.domain.ProductDetails;
import com.ylizma.stockmanagement.domain.ProductGroupDetails;
import com.ylizma.stockmanagement.model.Product;
import com.ylizma.stockmanagement.model.ProductGroup;
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
}
