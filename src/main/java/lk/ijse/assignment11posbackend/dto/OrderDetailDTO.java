package lk.ijse.assignment11posbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
    private String id;
    private LocalDate date;
    private CustomerDTO customer;
    private List<ItemDTO> items;
    private double discount;
    private double total;
}
