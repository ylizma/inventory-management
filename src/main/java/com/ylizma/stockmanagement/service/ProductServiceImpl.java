package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.ProductDetails;
import com.ylizma.stockmanagement.model.Product;
import com.ylizma.stockmanagement.model.ProductGroup;
import com.ylizma.stockmanagement.model.Supplier;
import com.ylizma.stockmanagement.model.WareHouse;
import com.ylizma.stockmanagement.respository.ProductGroupRepository;
import com.ylizma.stockmanagement.respository.ProductRepository;
import com.ylizma.stockmanagement.respository.SupplierRepository;
import com.ylizma.stockmanagement.respository.WareHouseRepository;
import com.ylizma.stockmanagement.service.helper.DomainConversion;
import com.ylizma.stockmanagement.util.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WareHouseRepository wareHouseRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    DomainConversion domainConversion;

    @Override
    public ProductDetails findByCode(String code) {
        Optional<Product> product = productRepository.findProductByCode(code);
        return product.map(value -> domainConversion.convertProductToDetails(value)).orElse(null);
    }

    @Override
    public Page<Product> findAll(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size, Sort.by("createdAt").descending()));
    }

    @Override
    public List<ProductDetails> findAllByWareHouseId(Long id) {
        List<ProductDetails> productDetailsList = new ArrayList<>();
        productRepository.findAllByWareHouseId(id)
                .forEach(product -> productDetailsList.add(domainConversion.convertProductToDetails(product)));
        return productDetailsList;
    }

    @Override
    public ResponseEntity<Object> save(ProductDetails p) throws ParseException {
        Optional<Product> tProduct = productRepository.findProductByCode(p.getCode());
        Product product = domainConversion.convertProductDetailsToProduct(p);
        if (tProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("this product exist already !!");
        } else {
            Optional<WareHouse> managedWareHouse = wareHouseRepository.findById(p.getWareHouse().getId());
            managedWareHouse.ifPresent(product::setWareHouse);
            Optional<Supplier> managedSupplier = supplierRepository.findById(p.getSupplier().getId());
            managedSupplier.ifPresent(product::setSupplier);
            Optional<ProductGroup> managedProductGroup = productGroupRepository.findById(p.getProductGroup().getId());
            managedProductGroup.ifPresent(product::setProductGroup);

            product.setCreatedAt(DateFormatter.getCurrentDate());
            product.setLastModified(DateFormatter.getCurrentDate());
            productRepository.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        }
    }

    @Override
    public ResponseEntity<Object> update(ProductDetails p, String code) throws ParseException {
        Optional<Product> managedProduct = productRepository.findProductByCode(code);
        Product unmanagedProduct = domainConversion.convertProductDetailsToProduct(p);
        if (managedProduct.isPresent()) {
            if (Optional.ofNullable(unmanagedProduct.getWareHouse()).isPresent()) {
                WareHouse managedWareHouse = managedProduct.get().getWareHouse();
                if (managedWareHouse != null) {
                    managedWareHouse.setActive(unmanagedProduct.getWareHouse().getActive());
                    managedWareHouse.setDescription(unmanagedProduct.getWareHouse().getDescription());
                    managedWareHouse.setName(unmanagedProduct.getWareHouse().getName());
                } else {
                    managedProduct.get().setWareHouse(unmanagedProduct.getWareHouse());
                }
            }
            if (Optional.ofNullable(unmanagedProduct.getSupplier()).isPresent()) {
                Supplier managedSupplier = managedProduct.get().getSupplier();
                if (managedSupplier != null) {
                    managedSupplier.setName(unmanagedProduct.getSupplier().getName());
                    managedSupplier.setActive(unmanagedProduct.getSupplier().isActive());
                    managedSupplier.setAddress(unmanagedProduct.getSupplier().getAddress());
                    managedSupplier.setCity(unmanagedProduct.getSupplier().getCity());
                    managedSupplier.setCompanyID(unmanagedProduct.getSupplier().getCompanyID());
                    managedSupplier.setFax(unmanagedProduct.getSupplier().getFax());
                    managedSupplier.setPhone(unmanagedProduct.getSupplier().getPhone());
                } else {
                    managedProduct.get().setSupplier(unmanagedProduct.getSupplier());
                }
            }
            if (Optional.ofNullable(unmanagedProduct.getProductGroup()).isPresent()) {
                ProductGroup managedProductGroup = managedProduct.get().getProductGroup();
                if (managedProductGroup != null) {
                    managedProductGroup.setActive(unmanagedProduct.getProductGroup().isActive());
                    managedProductGroup.setCode(unmanagedProduct.getProductGroup().getCode());
                    managedProductGroup.setName(unmanagedProduct.getProductGroup().getName());
                } else {
                    managedProduct.get().setProductGroup(unmanagedProduct.getProductGroup());
                }
            }
            managedProduct.get().setCode(unmanagedProduct.getCode());
            managedProduct.get().setDescription(unmanagedProduct.getDescription());
            managedProduct.get().setLastModified(DateFormatter.getCurrentDate());

            productRepository.save(managedProduct.get());

            return ResponseEntity.status(HttpStatus.OK).body(domainConversion.convertProductToDetails(managedProduct.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found !!");
    }

    @Override
    public ResponseEntity<Object> delete(String code) {
        Optional<Product> tProduct = productRepository.findProductByCode(code);
        if (tProduct.isPresent()) {
            productRepository.delete(tProduct.get());
            return ResponseEntity.status(HttpStatus.OK).body("the product is deleted !");
        } else return ResponseEntity.status(500).body("error ");
    }
}
