package edu.escuelaing.arsw.ase.app.introduccion.Ejercicio7;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatServerImpl extends UnicastRemoteObject implements ChatInterface {
    private List<String> messages = new ArrayList<>();

    protected ChatServerImpl() throws RemoteException {
        super();
    }

    public synchronized void sendMessage(String message) throws RemoteException {
        messages.add(message);
    }

    public synchronized String receiveMessage() throws RemoteException {
        if (messages.isEmpty()) {
            return null;
        }
        return messages.remove(0);
    }
}