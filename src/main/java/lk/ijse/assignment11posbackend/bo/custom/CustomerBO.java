package lk.ijse.assignment11posbackend.bo.custom;

import lk.ijse.assignment11posbackend.bo.SuperBO;
import lk.ijse.assignment11posbackend.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
    List<CustomerDTO> getAllCustomers() throws Exception;
    boolean saveCustomer(CustomerDTO dto) throws Exception;
    boolean updateCustomer(CustomerDTO dto) throws Exception;
    boolean deleteCustomer(String id) throws Exception;
}
