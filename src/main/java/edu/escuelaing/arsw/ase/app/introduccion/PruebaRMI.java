package edu.escuelaing.arsw.ase.app.introduccion;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class PruebaRMI {
    static MessengerService server;
    static MessengerService stub;
    static Registry registry;
    public static void main(String[] args) throws RemoteException {
        server = new MessengerServiceImpl();
        stub = (MessengerService) UnicastRemoteObject
                .exportObject((MessengerService) server, 0);

        registry = LocateRegistry.createRegistry(1099);
        registry.rebind("MessengerService", stub);
    }
}
