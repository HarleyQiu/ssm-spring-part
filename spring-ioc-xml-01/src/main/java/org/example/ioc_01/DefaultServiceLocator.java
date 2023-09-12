package org.example.ioc_01;

public class DefaultServiceLocator {

    private static final ClientServiceImpl clientService = new ClientServiceImpl();

    public ClientServiceImpl createClientServiceInstance() {
        return clientService;
    }
}