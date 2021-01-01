package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.dto.ProductDTO;
import com.dawidp.warehousemanagementsystem.model.Product;
import com.dawidp.warehousemanagementsystem.service.CategoryService;
import com.dawidp.warehousemanagementsystem.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dto/")
public class ProductDTOController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/getAllProducts")
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productService.getProducts();
        return products.stream()
                .map(product -> convertToDto(product))
                .collect(Collectors.toList());
    }


    private ProductDTO convertToDto(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }

    private Product convertToEntity(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        return product;
    }
}
