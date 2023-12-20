package lk.ijse.assignment11posbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    private String id;
    private LocalDate date;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @ManyToMany
    private List<Item> items;
    private double discount;
    private double total;
}
