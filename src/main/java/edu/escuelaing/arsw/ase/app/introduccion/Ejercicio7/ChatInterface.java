package edu.escuelaing.arsw.ase.app.introduccion.Ejercicio7;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInterface extends Remote {
    void sendMessage(String message) throws RemoteException;
    String receiveMessage() throws RemoteException;
}
