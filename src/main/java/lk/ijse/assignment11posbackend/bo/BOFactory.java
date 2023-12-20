package lk.ijse.assignment11posbackend.bo;

import lk.ijse.assignment11posbackend.bo.custom.Impl.CustomerBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER
    }

    public SuperBO getBO(BOTypes type){
        switch (type){
            case CUSTOMER: return new CustomerBOImpl();
            default: return null;
        }
    }
}
