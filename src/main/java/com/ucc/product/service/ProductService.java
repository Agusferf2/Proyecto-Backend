package com.ucc.product.service;

import com.ucc.product.model.entities.Product;
import com.ucc.product.model.dto.ProductDTO;
import com.ucc.product.model.dto.ProductInfoDTO;
import com.ucc.product.model.mappers.ProductsMappers;
import com.ucc.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductsMappers productsMappers;

    //Metodo que obtenga todos los productos guardados
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //Metodo que obtenga el producto por id
    public Product getProductByID(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    //Metodo que crea un producto
    public void createProduct(Product product){
        productRepository.save(product);
    }

    //Metodo para eliminar producto
    public void deleteProductByID(Long id){
        productRepository.deleteById(id);
    }

    //Metodo para editar producto
    public void editProductByID(Product product, Long id){
        Product existProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        existProduct.setName(product.getName());
        existProduct.setDescription(product.getDescription());
        existProduct.setStock(product.getStock());
        existProduct.setStatus(product.getStatus());
        existProduct.setPrice(product.getPrice());

        productRepository.save(existProduct);
    }

    public List<ProductInfoDTO> getAllInfoProducts(){
        return productRepository.findAll()
                .stream()
                .map(productEntity -> new ProductInfoDTO(productEntity.getId(), productEntity.getName(), productEntity.getCategory()))
                .collect(Collectors.toList());
    }

    //Metodo sin mapper
//    public ResponseEntity<Object> newProduct(ProductDTO productDTO){
//        Product productEntity = new Product();
//        productEntity.setName(productDTO.getName());
//        productEntity.setPrice(productDTO.getPrice());
//        productEntity.setStatus(Boolean.TRUE);
//        productRepository.save(productEntity);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }


    //Metodo con mapper
    public ResponseEntity<Object> newProduct(ProductDTO productDTO){
        Product productEntity = productsMappers.productsDTOtoProductsEntity(productDTO);
        productRepository.save(productEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
