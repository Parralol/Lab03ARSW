package edu.escuelaing.arsw.ase.app.introduccion;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Ejercicio2 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
        String res = "";
        System.out.println("Enter URL: \n");
        BufferedReader read = new BufferedReader(
                new InputStreamReader(System.in));
        String name = read.readLine();
        System.out.println(name);
        URL google = new URL(name);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                res += inputLine;
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        saveData(res);
    }

    private static void saveData(String a) {
        File file = new File("results/result.html");
        String data = a;
        try (FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] bytes = data.getBytes();
            bos.write(bytes);
            bos.close();
            fos.close();
            System.out.print("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
