package ptit.hdv.nhom8.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptit.hdv.nhom8.server.dto.OrderDTO;
import ptit.hdv.nhom8.server.entity.OrderEntity;
import ptit.hdv.nhom8.server.entity.OrderItemEntity;
import ptit.hdv.nhom8.server.mapper.Mapping;
import ptit.hdv.nhom8.server.repository.OrderItemRepository;
import ptit.hdv.nhom8.server.repository.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @PostMapping
    public String saveOrder(@RequestBody OrderDTO orderDTO) {
        try {
            System.out.println(orderDTO.toString());

            OrderEntity orderEntity = Mapping.mapOrderDTOtoOrderEntity(orderDTO);

            orderRepository.save(orderEntity);
            orderRepository.flush();

            List<OrderItemEntity> orderItemEntities = Mapping.mapItemsToListOrderItemEntity(orderDTO, orderEntity.getId());
//            for (OrderItemEntity i : orderItemEntities) {
                orderItemRepository.saveAll(orderItemEntities);
//            }

            return "ok";
        } catch (Exception e) {
            return "not ok";
        }
    }


}
