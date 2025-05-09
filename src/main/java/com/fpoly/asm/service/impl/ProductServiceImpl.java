package com.fpoly.asm.service.impl;

import com.fpoly.asm.controller.request.ProductRequest;
import com.fpoly.asm.entity.Product;
import com.fpoly.asm.repository.CategoryRepository;
import com.fpoly.asm.repository.ProductRepository;
import com.fpoly.asm.service.AbstractService;
import com.fpoly.asm.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j(topic = "Product-Service")
public class ProductServiceImpl extends AbstractService<Product, Integer, ProductRequest> implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        super(productRepository);
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void update(ProductRequest request) {
    }

    @Override
    public Page<Product> getProductByCategoryId(Integer categoryId, String sort, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sort).descending());
        return productRepository.findByCategoryId(categoryId, pageable);
    }

    @Override
    public Page<Product> getProductByKeyword(String keyword, String sort, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sort).descending());
        String kw = "%" + keyword.toLowerCase() + "%";
        return productRepository.findByKeyword(kw, pageable);
    }
}
