package edu.escuelaing.arsw.ase.app.introduccion;

import java.io.*;
import java.net.*;

public class URLReader {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
         URL google = new URL("http://www.google.com:80/xd?quer=asd#asdf");
        System.out.println("Authority: " + google.getAuthority() + "\n" + "Protocol: " + google.getProtocol() + "\n" + "Host: " +  google.getHost() + "\n" + "port: " +  google.getPort() + "\n" + "Path: " +  google.getPath() + "\n" + "Query: " +  google.getQuery()+ "\n" + "File: " +  google.getFile() + "\n" + "Reference: " +  google.getRef());
         try (BufferedReader reader
        = new BufferedReader(new InputStreamReader(google.openStream()))) {
         String inputLine = null;
        while ((inputLine = reader.readLine()) != null) {
         System.out.println(inputLine);
        }
         } catch (IOException x) {
        System.err.println(x);
    }
    }
}
