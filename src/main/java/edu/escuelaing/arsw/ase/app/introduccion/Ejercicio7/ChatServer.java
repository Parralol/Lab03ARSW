package edu.escuelaing.arsw.ase.app.introduccion.Ejercicio7;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
@SuppressWarnings("resource")
public class ChatServer {
    public static void main(String[] args) {
        try {
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el número de puerto para vincular el servidor: ");
            int port = scanner.nextInt();
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            LocateRegistry.createRegistry(port);

            ChatServerImpl chatServer = new ChatServerImpl();
            Naming.rebind("//localhost:" + port + "/ChatService", chatServer);
            System.out.println("Servidor de Chat está funcionando en el puerto " + port);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}