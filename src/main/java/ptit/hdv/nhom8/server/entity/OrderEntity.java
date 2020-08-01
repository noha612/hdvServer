package ptit.hdv.nhom8.server.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "`order`", schema = "btl_hdv")
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "date")
    private String date;

    @Column(name = "status")
    private String status;

    @Column(name = "method")
    private String method;

    @Column(name = "address")
    private String address;

}
