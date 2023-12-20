package lk.ijse.assignment11posbackend.dto;

import lk.ijse.assignment11posbackend.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private String id;
    private String name;
    private double price;
    private int qty;
    private List<OrderDetailDTO> Orders;
}
