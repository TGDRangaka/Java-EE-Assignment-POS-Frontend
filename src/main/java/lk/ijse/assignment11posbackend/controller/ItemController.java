package lk.ijse.assignment11posbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.assignment11posbackend.bo.BOFactory;
import lk.ijse.assignment11posbackend.bo.custom.ItemBO;
import lk.ijse.assignment11posbackend.dto.CustomerDTO;
import lk.ijse.assignment11posbackend.dto.ItemDTO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Item", urlPatterns = "/item", loadOnStartup = 5)
public class ItemController extends HttpServlet {

    private ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init()");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<ItemDTO> items = itemBO.getAllItems();
            System.out.println();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(items);

            resp.setContentType("application/json");
            resp.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ItemDTO itemDTO = mapper.readValue(req.getInputStream(), ItemDTO.class);
        System.out.println(itemDTO);

        try {
            if(itemBO.saveItem(itemDTO)){
                resp.getWriter().write("Item Saved");
            }else{
                resp.getWriter().write("Item Not Saved");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ItemDTO itemDTO = mapper.readValue(req.getInputStream(), ItemDTO.class);
        System.out.println(itemDTO);

        try {
            if(itemBO.updateItem(itemDTO)){
                resp.getWriter().write("Item Updated");
            }else{
                resp.getWriter().write("Item Not Updated");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try {
            if(itemBO.deleteItem(id)){
                resp.getWriter().write("Item Deleted");
            }else{
                resp.getWriter().write("Item Not Deleted");
            }
        } catch (Exception e) {
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
