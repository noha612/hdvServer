package ptit.hdv.nhom8.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ptit.hdv.nhom8.server.entity.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Integer> {
}
