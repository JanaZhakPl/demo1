package com.example.demo.services;

import com.example.demo.models.Image;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
@Slf4j //заменяем логгировние
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

//    public List<Product> listProducts()
//    { return productRepository.findAll();}

    public List<Product> listProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    //       public void saveProduct(Product product) {
//        log.info("Saving new {}", product);
//        productRepository.save(product);
//    }
    public void saveProduct(Product product, MultipartFile file) throws IOException {
        Image image;
        if (file.getSize() != 0) {
            image = toImageEntity(file);
            product.addImageToProduct(image);
        }
        log.info("Saving new Book. Title: {}; Author: {}; ", product.getTitle(), product.getAuthor());
        productRepository.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException { //from Multiparthfile to Image
        Image image = new Image();
        image.setOriginalFileName(file.getOriginalFilename());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;


    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

}
