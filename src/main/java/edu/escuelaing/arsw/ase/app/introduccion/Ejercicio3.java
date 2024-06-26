package edu.escuelaing.arsw.ase.app.introduccion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Calculates Power of 2
 */
public class Ejercicio3 {
    static String currentOp = null;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine;
        String res = "";
        while ((inputLine = in.readLine()) != null) {
            if(inputLine.split(":")[0].equals("fun")) changeOperation(inputLine);
            else{
                 res =operation(inputLine);
                System.out.println("Operacion:" + res);

            }
            System.out.println("Mensaje:" + inputLine);
            outputLine = "Respuesta " + inputLine;
            out.println(res);
            if (outputLine.equals("Respuestas: Bye."))
                break;
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    private static String changeOperation(String op){
        String operation = op.split(":")[1];
        if(!operation.equals("sin")|| !operation.equals("cos") || !operation.equals("tan")) return "Not accepted operation: " + op + " does not exist";
        currentOp = operation;
        return "change completed to " + op + " operation";
    }
    private static String operation(String op){
        String res = Double.toString(Math.pow(Integer.parseInt(op),2));
        return res;
    }
}
