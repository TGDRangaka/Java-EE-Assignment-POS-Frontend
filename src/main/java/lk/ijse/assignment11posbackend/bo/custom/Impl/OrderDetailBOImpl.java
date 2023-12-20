package lk.ijse.assignment11posbackend.bo.custom.Impl;

import lk.ijse.assignment11posbackend.bo.custom.OrderDetailBO;
import lk.ijse.assignment11posbackend.dto.OrderDetailDTO;
import lk.ijse.assignment11posbackend.entity.OrderDetail;
import lk.ijse.assignment11posbackend.service.ServiceFactory;
import lk.ijse.assignment11posbackend.service.custom.OrderDetailService;
import lk.ijse.assignment11posbackend.util.Convert;
import lk.ijse.assignment11posbackend.util.HibernateFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailBOImpl implements OrderDetailBO {

    private OrderDetailService orderDetailService = (OrderDetailService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.ORDER_DETAIL);

    @Override
    public List<OrderDetailDTO> getAllOrderDetails() throws Exception {
        List<OrderDetail> all = orderDetailService.getAll(HibernateFactoryConfig.getInstance().getSession());
        List<OrderDetailDTO> orderDetais = new ArrayList<>();
        for(OrderDetail od : all){
            orderDetais.add(Convert.orderDetailEntityToDto(od));
        }
        return orderDetais;
    }

    @Override
    public boolean saveOrderDetail(OrderDetailDTO dto) throws Exception {
        Session session = HibernateFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        if(orderDetailService.save(Convert.orderDetailDTOToEntity(dto), session)){
            transaction.commit();
            session.close();
            return true;
        }
        session.close();
        return false;
    }
}
