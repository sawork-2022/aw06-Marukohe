package com.example.batch.service;

import com.example.batch.model.Product;
import com.example.batch.repository.ProductRepository;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ProductWriter implements ItemWriter<Product>, StepExecutionListener {

    ProductRepository productRepository;

    public ProductWriter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public void write(List<? extends Product> list) throws Exception {
        productRepository.saveAll(list);
//        list.forEach(System.out::println);
//        System.out.println("chunk written");
    }
}
