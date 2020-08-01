package ptit.hdv.nhom8.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.hdv.nhom8.server.entity.ProductEntity;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> getProductsByTypeProductId(int typeProductId);

    List<ProductEntity> findAllByNameContains(String name);
}
