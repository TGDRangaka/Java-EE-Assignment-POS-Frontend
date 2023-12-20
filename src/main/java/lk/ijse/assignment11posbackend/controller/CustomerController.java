package lk.ijse.assignment11posbackend.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.assignment11posbackend.util.HibernateFactoryConfig;
import org.hibernate.Session;

import java.io.IOException;

@WebServlet(name = "Customer", urlPatterns = "/customer", loadOnStartup = 4)
public class CustomerController extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init()");
        Session session = HibernateFactoryConfig.getInstance().getSession();
        session.beginTransaction();
        session.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Customer Get()");
    }
}
