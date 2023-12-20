package lk.ijse.assignment11posbackend.bo;

import lk.ijse.assignment11posbackend.bo.custom.Impl.CustomerBOImpl;
import lk.ijse.assignment11posbackend.bo.custom.Impl.ItemBOImpl;
import lk.ijse.assignment11posbackend.bo.custom.Impl.OrderDetailBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER, ITEM, ORDER_DETAIL;
    }

    public SuperBO getBO(BOTypes type){
        switch (type){
            case CUSTOMER: return new CustomerBOImpl();
            case ITEM: return new ItemBOImpl();
            case ORDER_DETAIL: return  new OrderDetailBOImpl();
            default: return null;
        }
    }
}
