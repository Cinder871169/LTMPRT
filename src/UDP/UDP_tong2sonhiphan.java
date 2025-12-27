/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Admin
 */
public class UDP_tong2sonhiphan {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        String msg = ";B22DCCN822;lIQVug9S";
        
        DatagramPacket dpGui = new DatagramPacket(msg.getBytes(), msg.length(), ip, port);
        socket.send(dpGui);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String s = new String(dpNhan.getData());
        String[] parts = s.trim().split(";");
        String rqId = parts[0];
        String a = parts[1];
        String b = parts[2];
        int sum = Integer.parseInt(a, 2) + Integer.parseInt(b, 2);
        String res = String.valueOf(sum);
        
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), ip, port);
        socket.send(dpGui1);
        socket.close();
    }
}
