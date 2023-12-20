package lk.ijse.assignment11posbackend.bo.custom;

import lk.ijse.assignment11posbackend.bo.SuperBO;
import lk.ijse.assignment11posbackend.dto.OrderDetailDTO;

import java.util.List;

public interface OrderDetailBO extends SuperBO {
    List<OrderDetailDTO> getAllOrderDetails() throws Exception;
    boolean saveOrderDetail(OrderDetailDTO dto) throws Exception;
    boolean updateOrderDetail(OrderDetailDTO dto) throws Exception;
    boolean deleteOrderDetail(String id) throws Exception;
}
