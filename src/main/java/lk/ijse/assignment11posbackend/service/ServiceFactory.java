package lk.ijse.assignment11posbackend.service;

import lk.ijse.assignment11posbackend.service.custom.Impl.CustomerServiceImpl;
import lk.ijse.assignment11posbackend.service.custom.Impl.ItemServiceImpl;
import lk.ijse.assignment11posbackend.service.custom.Impl.OrderDetailServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return serviceFactory == null ? serviceFactory = new ServiceFactory() : serviceFactory;
    }

    public enum ServiceTypes{
        CUSTOMER, ITEM, ORDER_DETAIL;
    }

    public SuperService getService(ServiceTypes type){
        switch (type){
            case CUSTOMER: return new CustomerServiceImpl();
            case ITEM: return new ItemServiceImpl();
            case ORDER_DETAIL: return new OrderDetailServiceImpl();
            default: return null;
        }
    }
}
