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
public class UDP_phantulonnhatdaycon {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        String msg = ";B22DCCN822;iv00Hrq6";
        
        DatagramPacket dpGui = new DatagramPacket(msg.getBytes(), msg.length(), ip, port);
        socket.send(dpGui);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData());
        String[] parts = s.trim().split("\\s+");
        String rqId = parts[0];
        int n = Integer.parseInt(parts[1]);
        int k = Integer.parseInt(parts[2]);
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 3; i < parts.length; i++){
            a.add(Integer.parseInt(parts[i]));
        }
        String res = rqId + ";";
        for(int i = 0; i <= n - k; i++){
            int MAX = a.get(i);
            for(int j = i + 1; j <= i + k - 1; j++){
                if (a.get(j) > MAX){
                    MAX = a.get(j);
                }
            }
            res += MAX + ",";
        }
        res = res.substring(0, res.length() - 1);
        
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), ip, port);
        socket.send(dpGui1);
        socket.close();
    }
}
