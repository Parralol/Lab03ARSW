package edu.escuelaing.arsw.ase.app.introduccion;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;

public class Ejercicio5 {

    private static String path = "src\\main\\java\\edu\\escuelaing\\arsw\\ase\\app\\resources\\";

    public static class HttpContext {

        public final static String getHtml() {
            return "text/html";
        }

        public final static String getImg() {
            return "image/webp";
        }

        public final static String getCss() {
            return "text/css";
        }

        public final static String getJs() {
            return "text/javascript";
        }
    }

    private static String[] getPath(String a) {
        String[] pathQuery = a.split(" ");
        String[] path = pathQuery[1].split("\\?");
        System.out.println(Arrays.toString(path));
        return path;
    }

    private static String[] generateResponse(String[] a) {
        String[] res;
        if (a.length > 1) {
            res = document(a[1]);
            if (!Boolean.valueOf(res[0])) {
                try {
                    String[] resp = { res[0], res[1], getFile(getFileName(a[1])) };
                    res = resp;
                } catch (IOException e) {
                    String[] resp = { res[0], res[1], "FILE NOT FOUND: " + e.getMessage() };
                    res = resp;
                }
            }
        } else {
            res = document(a[0]);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    private static String[] document(String a) {
        String fileType = getFileType(a);
        String type;
        boolean image = false;
        System.out.println(fileType);
        if (fileType.equals("css")) {
            type = HttpContext.getCss();
        } else if (fileType.equals("js")) {
            type = HttpContext.getJs();
        } else if (fileType.equals("webp") || fileType.equals("jpg") || fileType.equals("png")) {
            type = HttpContext.getImg();
            image = true;
        } else {
            type = HttpContext.getHtml();
        }

        String[] res = { String.valueOf(image), "HTTP/1.1 200 OK\r\n"
                + "Content-Type:" + type + "\r\n"//
                + "\r\n" //
        };
        return res;
    }

    private static String getFileType(String a) {
        String res = "";
        String[] mini = a.split("\\=");
        if (mini.length > 1) {
            String file = a.split("\\=")[1];
            String[] nameType = file.split("\\.");
            if (nameType.length > 1) {
                res = nameType[1];
            }
        }

        return res;
    }

    public static String getFileName(String a) {
        String res = "";
        String[] mini = a.split("\\=");
        if (mini.length > 1) {
            res = a.split("\\=")[1];

        }

        return res;
    }

    private static String getIndex() throws IOException {
        String content = new String(Files
                .readAllBytes(Paths.get(path + "index.html")));

        String res = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"//
                + "\r\n" //
                + content;
        return res;
    }

    private static String getFile(String a) throws IOException {
        String content = new String(Files
                .readAllBytes(Paths.get(path + a)));

        return content;
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
        while (running) {
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
            boolean header = true;
            String textHeader = "";

            while ((inputLine = in.readLine()) != null) {
                if (header) {
                    textHeader = inputLine;
                    header = false;
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }

            String[] a = getPath(textHeader);
            if (a[0].split("/").length == 0) {
                outputLine = getIndex() + inputLine;
                out.println(outputLine);
                out.close();
            } else {
                String[] res = generateResponse(a);
                System.out.println(textHeader);
                outputLine = res[1];
                if (!Boolean.valueOf(res[0])) {
                    
                    if(res.length<=2){
                        outputLine +=  inputLine;
                    }else{
                        outputLine += res[2] + inputLine;
                    }
                   

                } else {
                    try{
                       // out.println(outputLine);
                        byte[] bytes = Files.readAllBytes(Paths.get(path + getFileName(a[1])));
                        String base64 = Base64.getEncoder().encodeToString(bytes);
                        outputLine += "<!DOCTYPE html>\r\n"
                        + "<html>\r\n"
                        + "    <head>\r\n"
                        + "        <title>Resultado</title>\r\n"
                        + "    </head>\r\n"
                        + "    <body>\r\n"
                        + "         <center><img src=\"data:image/jpeg;base64," + base64 + "\" alt=\"image\"></center>" + "\r\n"
                        + "    </body>\r\n"
                        + "</html>";
                    }catch(Exception e){
                        outputLine += "FILE NOT FOUND"+ inputLine;
                    }
                }
                out.println(outputLine);
                out.close();
            }

            in.close();

            clientSocket.close();
        }
        serverSocket.close();

    }
}
