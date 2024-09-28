package com.example.rateplanmicroservice.controller;

import com.example.rateplanmicroservice.dto.ProductDTO;
import com.example.rateplanmicroservice.model.Product;
import com.example.rateplanmicroservice.model.Organization;
import com.example.rateplanmicroservice.model.Division;
import com.example.rateplanmicroservice.model.Producer;
import com.example.rateplanmicroservice.service.ProductService;
import com.example.rateplanmicroservice.service.OrganizationService;
import com.example.rateplanmicroservice.service.DivisionService;
import com.example.rateplanmicroservice.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private ProducerService producerService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(convertToDTO(product));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        // Fetch the producer entity by producerId
        Producer producer = producerService.getProducerById(productDTO.getProducerId());
        if (producer == null) {
            return ResponseEntity.badRequest().body(null); // Invalid producerId
        }

        // Fetch the organization or division based on the productDTO
        Organization organization = null;
        Division division = null;

        if (productDTO.getOrganizationId() != null) {
            organization = organizationService.getOrganizationEntityById(productDTO.getOrganizationId());
            if (organization == null) {
                return ResponseEntity.badRequest().body(null); // Invalid organizationId
            }
        }

        if (productDTO.getDivisionId() != null) {
            division = divisionService.getDivisionById(productDTO.getDivisionId());
            if (division == null) {
                return ResponseEntity.badRequest().body(null); // Invalid divisionId
            }
        }

        // Ensure organization and division are mutually exclusive
        if (organization != null && division != null) {
            return ResponseEntity.badRequest().body(null); // Both cannot be present at the same time
        }

        // Check for producerProvidedProductId, ensure it's not null
        if (productDTO.getProducerProvidedProductId() == null || productDTO.getProducerProvidedProductId().isEmpty()) {
            return ResponseEntity.badRequest().body(null); // producerProvidedProductId is mandatory
        }

        // Create product entity from DTO
        Product product = convertToEntity(productDTO);
        product.setProducer(producer);
        product.setOrganization(organization); // Null if not set
        product.setDivision(division); // Null if not set

        // Save product
        product = productService.saveProduct(product);

        return ResponseEntity.ok(convertToDTO(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setProductDescription(product.getProductDescription());
        dto.setStatus(product.getStatus().name());
        dto.setProducerId(product.getProducer().getProducerId());
        dto.setOrganizationId(product.getOrganization() != null ? product.getOrganization().getOrganizationId() : null);
        dto.setDivisionId(product.getDivision() != null ? product.getDivision().getDivisionId() : null);
        dto.setProducerProvidedProductId(product.getProducerProvidedProductId());  // Add this line
        return dto;
    }

    private Product convertToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setProductName(dto.getProductName());
        product.setProductDescription(dto.getProductDescription());
        product.setStatus(Product.Status.valueOf(dto.getStatus()));
        product.setProducerProvidedProductId(dto.getProducerProvidedProductId());  // Add this line
        return product;
    }
}
