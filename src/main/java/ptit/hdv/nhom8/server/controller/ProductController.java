package ptit.hdv.nhom8.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptit.hdv.nhom8.server.entity.ProductEntity;
import ptit.hdv.nhom8.server.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getListProducts(
            @RequestParam(name = "type_product_id", required = false) String typeProductId,
            @RequestParam(name = "query_name", required = false) String queryName
    ) {
        if (typeProductId != null) {
            int type = Integer.parseInt(typeProductId);
            List<ProductEntity> productEntities = productRepository.getProductsByTypeProductId(type);
            return new ResponseEntity<List<ProductEntity>>(productEntities, HttpStatus.OK);
        }
        if (queryName != null) {
            List<ProductEntity> productEntities = productRepository.findAllByNameContains(queryName);
            return new ResponseEntity<List<ProductEntity>>(productEntities, HttpStatus.OK);
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProduct(@PathVariable(name = "id") int id) {
        Optional opt = productRepository.findById(id);
        ProductEntity productEntity = (ProductEntity) opt.get();
        return new ResponseEntity<ProductEntity>(productEntity, HttpStatus.OK);
    }

    @PostMapping
    public String addProduct(@RequestBody ProductEntity productEntity) {
        try {
            productRepository.save(productEntity);
            return "ok";
        } catch (Exception e) {
            return "not ok";
        }
    }

    @PutMapping
    public String editProduct(@RequestBody ProductEntity productEntity) {
        try {
            productRepository.save(productEntity);
            return "ok";
        } catch (Exception e) {
            return "not ok";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        try {
            productRepository.deleteById(id);
            return "ok";
        } catch (Exception e) {
            return "not ok";
        }
    }
}
