package ptit.hdv.nhom8.server.mapper;

import ptit.hdv.nhom8.server.dto.OrderDTO;
import ptit.hdv.nhom8.server.entity.OrderEntity;
import ptit.hdv.nhom8.server.entity.OrderItemEntity;
import ptit.hdv.nhom8.server.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class Mapping {
    public static OrderEntity mapOrderDTOtoOrderEntity(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setAddress(orderDTO.getUser().getAddress().equals("null") ? "Ha Noi" : orderDTO.getUser().getAddress());
        orderEntity.setDate(orderDTO.getDate());
        orderEntity.setUserId(orderDTO.getUser().getId());
        orderEntity.setMethod(orderDTO.getMethod());
        orderEntity.setStatus(orderDTO.getStatus());
        return orderEntity;
    }

    public static List<OrderItemEntity> mapItemsToListOrderItemEntity(OrderDTO orderDTO, int id) {
        List<OrderItemEntity> orderItemEntities = new ArrayList<>();
        for (ProductEntity i : orderDTO.getItems()) {
            OrderItemEntity o = new OrderItemEntity();
            o.setOrderId(id);
            o.setName(i.getName());
            o.setPrice((double) i.getPrice());
            orderItemEntities.add(o);
        }
        return orderItemEntities;
    }
}
