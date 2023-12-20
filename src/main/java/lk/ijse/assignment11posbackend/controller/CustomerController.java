package lk.ijse.assignment11posbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.assignment11posbackend.bo.BOFactory;
import lk.ijse.assignment11posbackend.bo.custom.CustomerBO;
import lk.ijse.assignment11posbackend.bo.custom.Impl.CustomerBOImpl;
import lk.ijse.assignment11posbackend.dto.CustomerDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Customer", urlPatterns = "/customer", loadOnStartup = 4)
public class CustomerController extends HttpServlet {

    private CustomerBO customerBO = (CustomerBOImpl) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<CustomerDTO> customers = customerBO.getAllCustomers();
            System.out.println();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonCustomers = objectMapper.writeValueAsString(customers);

            resp.setContentType("application/json");
            resp.getWriter().write(jsonCustomers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        CustomerDTO customer = mapper.readValue(req.getInputStream(), CustomerDTO.class);
        System.out.println(customer);

        try {
            if(customerBO.saveCustomer(customer)){
                resp.getWriter().write("Customer Saved");
            }else{
                resp.getWriter().write("Customer Not Saved");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        CustomerDTO customer = mapper.readValue(req.getInputStream(), CustomerDTO.class);
        System.out.println(customer);

        try {
            if(customerBO.updateCustomer(customer)){
                resp.getWriter().write("Customer Updated");
            }else{
                resp.getWriter().write("Customer Not Updated");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setHeader("Access-Control-Max-Age", "3600");
    }
}
