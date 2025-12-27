/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

/**
 *
 * @author Admin
 */
public class UDP_sapxeptudiennguoc {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        String msg = ";B22DCCN822;9UfU4Vky";
        
        DatagramPacket dpGui = new DatagramPacket(msg.getBytes(), msg.length(), ip, port);
        socket.send(dpGui);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String s = new String(dpNhan.getData());
        s.replace(";", " ");
        String[] parts = s.split("\\s+");
        String rqId = parts[0];
        ArrayList<String> a = new ArrayList<>();
        for(int i = 1; i < parts.length; i++){
            a.add(parts[i]);
        }
        Collections.sort(a, (String s1, String s2) -> s2.toLowerCase().compareTo(s1.toLowerCase()));
        String res = rqId + ";";
        for(String i : a){
            res += i + ",";
        }
        res = res.substring(0, res.length() - 1);
        
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), ip, port);
        socket.send(dpGui1);
        socket.close();
    }
}
