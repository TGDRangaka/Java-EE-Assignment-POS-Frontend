package lk.ijse.assignment11posbackend.bo.custom.Impl;

import lk.ijse.assignment11posbackend.bo.custom.CustomerBO;
import lk.ijse.assignment11posbackend.dto.CustomerDTO;
import lk.ijse.assignment11posbackend.entity.Customer;
import lk.ijse.assignment11posbackend.service.ServiceFactory;
import lk.ijse.assignment11posbackend.service.custom.CustomerService;
import lk.ijse.assignment11posbackend.service.custom.Impl.CustomerServiceImpl;
import lk.ijse.assignment11posbackend.util.Convert;
import lk.ijse.assignment11posbackend.util.HibernateFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    private CustomerService customerService = (CustomerServiceImpl)ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        List<Customer> all = customerService.getAll(HibernateFactoryConfig.getInstance().getSession());
        List<CustomerDTO> customerDTOs = new ArrayList<>();
        for (Customer customer : all) {
            customerDTOs.add(Convert.customerEntityToDto(customer));
        }
        return customerDTOs;
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        Session session = HibernateFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        if(customerService.save(Convert.customerDTOToEntity(dto), session)){
            transaction.commit();
            return true;
        }

        session.close();
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        Session session = HibernateFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        if(customerService.update(Convert.customerDTOToEntity(dto), session)){
            transaction.commit();
            return true;
        }

        session.close();
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return false;
    }
}
