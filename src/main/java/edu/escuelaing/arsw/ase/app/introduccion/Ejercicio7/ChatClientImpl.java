package edu.escuelaing.arsw.ase.app.introduccion.Ejercicio7;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatClientImpl extends UnicastRemoteObject implements ChatInterface {
    protected ChatClientImpl() throws RemoteException {
        super();
    }

    public void sendMessage(String message) throws RemoteException {

    }

    public String receiveMessage() throws RemoteException {
        return null;
    }
}