package lk.ijse.assignment11posbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    private Customer customer;
    @ManyToMany
    private List<Item> items;
    private double discount;
    private double total;
}
