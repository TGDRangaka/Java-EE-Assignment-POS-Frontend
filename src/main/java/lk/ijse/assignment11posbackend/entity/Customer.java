package lk.ijse.assignment11posbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private String id;
    private String name;
    private String address;
    private double salary;
    @OneToMany(mappedBy = "customer",orphanRemoval = true, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
}
