package lk.ijse.assignment11posbackend.service;

import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface Crud<T> extends SuperService{
    List<T> getAll(Session session) throws Exception;
    boolean save(T t, Session session) throws Exception;
    boolean update(T t, Session session) throws Exception;
    boolean delete(String id, Session session) throws Exception;
}
