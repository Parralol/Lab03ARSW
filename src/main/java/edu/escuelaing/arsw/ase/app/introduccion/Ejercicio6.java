package edu.escuelaing.arsw.ase.app.introduccion;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.escuelaing.arsw.ase.app.introduccion.Datagram.DatagramTimeClient;

public class Ejercicio6 {

    static String received;

    static DatagramSocket socket;
    static byte[] sendBuf;
    static byte[] buf;
    static InetAddress address;
    static DatagramPacket packet;

    @SuppressWarnings({ "unused", "resource" })
    public static void main(String[] args) throws InterruptedException {
        connect();
        while (true) {
            try {
                Thread.sleep(5000);
                socket.send(packet);
                packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Date: " + received);
            } catch (SocketTimeoutException ex) {
                System.out.println("Date: " + received);
                connect();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void connect() {
        try {
            sendBuf = new byte[256];
            socket = new DatagramSocket();
            buf = new byte[256];
            address = InetAddress.getByName("127.0.0.1");
            packet = new DatagramPacket(buf, buf.length, address, 4445);
            socket.setSoTimeout(2000);
        } catch (UnknownHostException ex) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
