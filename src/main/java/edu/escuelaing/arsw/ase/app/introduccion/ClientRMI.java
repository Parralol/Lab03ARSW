package edu.escuelaing.arsw.ase.app.introduccion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRMI {
    public static void main(String[] args) throws NotBoundException, IOException {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        System.out.println("enter Ip to connect: \n");
        String ip = reader.readLine();
        System.out.println("enter port to connect: \n");
        int port = Integer.valueOf(reader.readLine());
        Registry registry = LocateRegistry.getRegistry(port);
        MessengerService server = (MessengerService) registry
                .lookup("MessengerService");


    
        while(true){
        // Reading data using readLine
        String name = reader.readLine();
        
        String responseMessage = server.sendMessage(name);
        String expectedMessage = "Server Message";
        System.out.println(Boolean.toString(expectedMessage.equals(responseMessage)) +"---->" + responseMessage);

    }
    }
    
}
