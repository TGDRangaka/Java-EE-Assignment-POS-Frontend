package lk.ijse.assignment11posbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.assignment11posbackend.bo.BOFactory;
import lk.ijse.assignment11posbackend.bo.custom.OrderDetailBO;
import lk.ijse.assignment11posbackend.dto.OrderDetailDTO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderDetail", urlPatterns = "/orderdetail", loadOnStartup = 3)
public class OrderDetailController extends HttpServlet {

    private OrderDetailBO orderDetailBO = (OrderDetailBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER_DETAIL);

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<OrderDetailDTO> allOrderDetails = orderDetailBO.getAllOrderDetails();
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            String json = mapper.writeValueAsString(allOrderDetails);

            resp.setContentType("application/json");
            resp.getWriter().write(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("id"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        OrderDetailDTO orderDetailDTO = mapper.readValue(req.getInputStream(), OrderDetailDTO.class);
        System.out.println(orderDetailDTO);

        try {
            if(orderDetailBO.saveOrderDetail(orderDetailDTO)){
                resp.getWriter().write("Order Saved");
            }else{
                resp.getWriter().write("Order Not Saved");
            }
        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setHeader("Access-Control-Max-Age", "3600");
    }
}
