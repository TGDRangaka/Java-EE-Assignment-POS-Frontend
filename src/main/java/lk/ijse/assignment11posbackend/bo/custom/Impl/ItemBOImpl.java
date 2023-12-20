package lk.ijse.assignment11posbackend.bo.custom.Impl;

import lk.ijse.assignment11posbackend.bo.custom.ItemBO;
import lk.ijse.assignment11posbackend.dto.CustomerDTO;
import lk.ijse.assignment11posbackend.dto.ItemDTO;
import lk.ijse.assignment11posbackend.entity.Customer;
import lk.ijse.assignment11posbackend.entity.Item;
import lk.ijse.assignment11posbackend.service.ServiceFactory;
import lk.ijse.assignment11posbackend.service.custom.Impl.ItemServiceImpl;
import lk.ijse.assignment11posbackend.service.custom.ItemService;
import lk.ijse.assignment11posbackend.util.Convert;
import lk.ijse.assignment11posbackend.util.HibernateFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    private ItemService itemService = (ItemServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);

    @Override
    public List<ItemDTO> getAllItems() throws Exception {
        List<Item> all = itemService.getAll(HibernateFactoryConfig.getInstance().getSession());
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item : all) {
            itemDTOS.add(Convert.itemEntityToDto(item));
        }
        return itemDTOS;
    }

    @Override
    public boolean saveItem(ItemDTO dto) throws Exception {
        Session session = HibernateFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        if(itemService.save(Convert.itemDTOToEntity(dto), session)){
            transaction.commit();
            session.close();
            return true;
        }

        session.close();
        return false;
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws Exception {
        Session session = HibernateFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        if(itemService.update(Convert.itemDTOToEntity(dto), session)){
            transaction.commit();
            session.close();
            return true;
        }

        session.close();
        return false;
    }

    @Override
    public boolean deleteItem(String id) throws Exception {
        Session session = HibernateFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        if(itemService.delete(id, session)){
            transaction.commit();
            session.close();
            return true;
        }

        session.close();
        return false;
    }
}
