package com.ucc.product.service;

import com.ucc.product.model.Product;
import com.ucc.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

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
}
