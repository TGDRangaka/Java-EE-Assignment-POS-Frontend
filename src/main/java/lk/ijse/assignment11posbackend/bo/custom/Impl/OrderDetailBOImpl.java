package lk.ijse.assignment11posbackend.bo.custom.Impl;

import lk.ijse.assignment11posbackend.bo.custom.OrderDetailBO;
import lk.ijse.assignment11posbackend.dto.OrderDetailDTO;

import java.util.List;

public class OrderDetailBOImpl implements OrderDetailBO {
    @Override
    public List<OrderDetailDTO> getAllOrderDetails() throws Exception {
        return null;
    }

    @Override
    public boolean saveOrderDetail(OrderDetailDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateOrderDetail(OrderDetailDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteOrderDetail(String id) throws Exception {
        return false;
    }
}
