package lk.ijse.assignment11posbackend.bo.custom;

import lk.ijse.assignment11posbackend.bo.SuperBO;
import lk.ijse.assignment11posbackend.dto.ItemDTO;

import java.util.List;

public interface ItemBO extends SuperBO {
    List<ItemDTO> getAllItems() throws Exception;
    boolean saveItem(ItemDTO dto) throws Exception;
    boolean updateItem(ItemDTO dto) throws Exception;
    boolean deleteItem(String id) throws Exception;
}
