package lk.ijse.assignment11posbackend.util;

import lk.ijse.assignment11posbackend.dto.CustomerDTO;
import lk.ijse.assignment11posbackend.dto.ItemDTO;
import lk.ijse.assignment11posbackend.dto.OrderDetailDTO;
import lk.ijse.assignment11posbackend.entity.Customer;
import lk.ijse.assignment11posbackend.entity.Item;
import lk.ijse.assignment11posbackend.entity.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public class Convert {

    public static Customer customerDTOToEntity(CustomerDTO dto){
        return new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary(), null);
    }
    public static CustomerDTO customerEntityToDto(Customer customer){
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary(), null);
    }


    public static Item itemDTOToEntity(ItemDTO dto){
        return new Item(dto.getId(), dto.getName(), dto.getPrice(), dto.getQty(), null);
    }
    public static ItemDTO itemEntityToDto(Item item){
        return new ItemDTO(item.getId(), item.getName(), item.getPrice(), item.getQty(), null);
    }


    public static OrderDetail orderDetailDTOToEntity(OrderDetailDTO dto){
        List<Item> items = new ArrayList<>();
        for (ItemDTO i : dto.getItems()) {
            items.add(itemDTOToEntity(i));
        }
        return new OrderDetail(dto.getId(), dto.getDate(), customerDTOToEntity(dto.getCustomer()), items, dto.getDiscount(), dto.getTotal());
    }
    public static OrderDetailDTO orderDetailEntityToDto(OrderDetail od){
        List<ItemDTO> items = new ArrayList<>();
        for (Item i : od.getItems()) {
            items.add(itemEntityToDto(i));
        }
        return new OrderDetailDTO(od.getId(), od.getDate(), customerEntityToDto(od.getCustomer()), items, od.getDiscount(), od.getTotal());
    }
}
