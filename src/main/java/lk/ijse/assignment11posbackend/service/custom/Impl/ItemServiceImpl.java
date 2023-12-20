package lk.ijse.assignment11posbackend.service.custom.Impl;

import lk.ijse.assignment11posbackend.entity.Item;
import lk.ijse.assignment11posbackend.service.custom.ItemService;
import org.hibernate.Session;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Override
    public List<Item> getAll(Session session) throws Exception {
        return session.createQuery("FROM Item ", Item.class).getResultList();
    }

    @Override
    public boolean save(Item item, Session session) throws Exception {
        session.persist(item);
        return true;
    }

    @Override
    public boolean update(Item item, Session session) throws Exception {
        session.update(item);
        return true;
    }

    @Override
    public boolean delete(String id, Session session) throws Exception {
        session.remove(session.get(Item.class, id));
        return true;
    }
}
