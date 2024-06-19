package edu.escuelaing.arsw.ase.app.introduccion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ejercicio5 {

    public class HttpContext {
    
        public final String getHtml(){
            return "text/html" + "\r\n";
        }
        public final String getImg(){
            return "image/webp";
        }
        public final String getCss(){
            return "text/css";
        }
    
        public final String getJs(){
            return "text/javascript";
        }
    }
public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean running = true;
        while(running){
        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }

        outputLine = Html() + inputLine;

        out.println(outputLine);

        out.close();

        in.close();
    
        clientSocket.close();
        }
        serverSocket.close();

    }

    public static String response(){
        String res = "";
        return res;
    }

    public static String Html() throws IOException{
        String content = new String(Files.readAllBytes(Paths.get("src\\main\\java\\edu\\escuelaing\\arsw\\ase\\app\\resources\\index.html")));

        String res = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"//
                +   "\r\n" //
                +   content;
            return res;
    }
}
