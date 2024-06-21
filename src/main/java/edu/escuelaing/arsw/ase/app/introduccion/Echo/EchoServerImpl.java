package edu.escuelaing.arsw.ase.app.introduccion.Echo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("deprecation")
public class EchoServerImpl implements EchoServer {


    @SuppressWarnings("removal")
    public EchoServerImpl(String ipRMIregistry,
            int puertoRMIregistry, String nombreDePublicacion) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            EchoServer echoServer = (EchoServer) UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry(ipRMIregistry, puertoRMIregistry);
            registry.rebind(nombreDePublicacion, echoServer);
            System.out.println("Echo server ready...");
        } catch (Exception e) {
            System.err.println("Echo server exception:");
            e.printStackTrace();
        }
    }

    public String echo(String cadena) throws RemoteException {
        return "desde el servidor: " + cadena;
    }

    public static void main(String[] args) {
        EchoServerImpl ec = new EchoServerImpl("127.0.0.1", 23000, "echoServer");
    }
}
