package lk.ijse.assignment11posbackend.service;

import lk.ijse.assignment11posbackend.service.custom.Impl.CustomerServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return serviceFactory == null ? serviceFactory = new ServiceFactory() : serviceFactory;
    }

    public enum ServiceTypes{
        CUSTOMER
    }

    public SuperService getService(ServiceTypes type){
        switch (type){
            case CUSTOMER: return new CustomerServiceImpl();
            default: return null;
        }
    }
}
