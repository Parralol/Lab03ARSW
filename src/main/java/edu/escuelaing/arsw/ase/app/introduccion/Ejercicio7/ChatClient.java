package edu.escuelaing.arsw.ase.app.introduccion.Ejercicio7;

import java.rmi.Naming;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la dirección IP : \n");
            String serverIp = scanner.nextLine();
            System.out.print("Ingrese el número de puerto: \n");
            int serverPort = scanner.nextInt();
            scanner.nextLine(); 

            ChatInterface chatServer = (ChatInterface) Naming.lookup("//" + serverIp + ":" + serverPort + "/ChatService");
            System.out.println("Conectado al servidor de chat");

            Thread messageReceiver = new Thread(() -> {
                try {
                    while (true) {
                        String message = chatServer.receiveMessage();
                        if (message != null) {
                            System.out.println("Recibido: " + message);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            messageReceiver.start();

            while (true) {
                System.out.print("Ingrese mensaje: ");
                String message = scanner.nextLine();
                chatServer.sendMessage(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}