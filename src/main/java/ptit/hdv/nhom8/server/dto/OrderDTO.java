package ptit.hdv.nhom8.server.dto;

import lombok.*;
import ptit.hdv.nhom8.server.entity.ProductEntity;
import ptit.hdv.nhom8.server.entity.UserEntity;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {

    private UserEntity user;
    private String method;
    private String date;
    private String status;

    private List<ProductEntity> items;
}
