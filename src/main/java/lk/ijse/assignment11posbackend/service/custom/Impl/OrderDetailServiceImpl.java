package lk.ijse.assignment11posbackend.service.custom.Impl;

import lk.ijse.assignment11posbackend.entity.OrderDetail;
import lk.ijse.assignment11posbackend.service.custom.OrderDetailService;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    @Override
    public List<OrderDetail> getAll(Session session) throws Exception {
        return session.createQuery("FROM OrderDetail ", OrderDetail.class).getResultList();
    }

    @Override
    public boolean save(OrderDetail orderDetail, Session session) throws Exception {
        session.persist(orderDetail);
        return true;
    }

    @Override
    public boolean update(OrderDetail orderDetail, Session session) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id, Session session) throws Exception {
        return false;
    }
}
