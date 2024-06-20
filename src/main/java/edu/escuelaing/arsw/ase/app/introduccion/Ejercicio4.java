package edu.escuelaing.arsw.ase.app.introduccion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Ejercicio4 {
    static String currentOp = "cos";
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
                res = Double.toString(operation(inputLine));
                System.out.println("Operacion:" + inputLine);
                System.out.println("res:" + res);

            }
            System.out.println("Mensaje:" + inputLine);
            outputLine = "Respuesta " + res;
            out.println(outputLine);
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
    private static Double operation(String op){
        Double res = 0.0;
        boolean div = false;
        boolean sum = false;
        boolean rest = false;
        boolean mult = false;
        double val1 = 0.0;
        double val2 = 0.0;
        System.out.println(op.split("/").length);
        if(op.split("/").length > 1){
            String[] resp = op.split("/");
            div = true;
            System.out.println("INDEX: " + resp[0].indexOf('?'));
            if(resp[0].indexOf('?') >= 0){
                val1 = Math.PI;
                val2 = Double.parseDouble(resp[1]);
            }else if(resp[1].indexOf('?') >= 0){
                val1 = Double.parseDouble(resp[0]);
                val2 = Math.PI;
            }else{

            }
        } 
        else if(op.split("\\+ ").length > 1){
            String[] resp = op.split("\\+");
            sum = true;
            if(resp[0].indexOf('?') >= 0){
                val1 = Math.PI;
                val2 = Double.parseDouble(resp[1]);
            }else if(resp[1].indexOf('?') >= 0){
                val1 = Double.parseDouble(resp[0]);
                val2 = Math.PI;
            }
        }
        else if(op.split("\\*").length > 1){
            String[] resp = op.split("\\*");
            mult = true;
            if(resp[0].indexOf('?') >= 0){
                val1 = Math.PI;
                val2 = Double.parseDouble(resp[1]);
            }else if(resp[1].indexOf('?') >= 0){
                val1 = Double.parseDouble(resp[0]);
                val2 = Math.PI;
            }
        }
        else if(op.split("\\-").length > 1){
            String[] resp = op.split("\\-");
            rest = true;
            if(resp[0].indexOf('?') >= 0){
                val1 = Math.PI;
                val2 = Double.parseDouble(resp[1]);
            }else if(resp[1].indexOf('?') >= 0){
                val1 = Double.parseDouble(resp[0]);
                val2 = Math.PI;
            }
        }
        System.out.println(val1 + "-----------" + val2);
        if(currentOp.equals("sin")){
            if(sum)res =Math.sin(val1 + val2);
            if(rest)res =Math.sin(val1 - val2);
            if(div)res =Math.sin(val1 / val2);
            if(mult)res =Math.sin(val1 * val2);
            else res = Math.sin(val1);
            
        }
        else if(currentOp.equals("cos")){
            if(sum)res =Math.cos(val1 + val2);
            if(rest)res =Math.cos(val1 - val2);
            if(div)res =Math.cos(val1 / val2);
            if(mult)res =Math.cos(val1 * val2);
            else res = Math.cos(val1);
        }
        else if(currentOp.equals("tan")){
            if(sum) res = Math.tan(val1 + val2);
            if(rest)res =Math.tan(val1 - val2);
            if(div)res =Math.tan(val1 / val2);
            if(mult)res = Math.tan(val1 * val2);
            else res = Math.tan(val1);
        }

        return res;
    }
}
