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
public class UDP_timsoconthieu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        String msg = ";B22DCCN822;wAKCZwjj";
        
        DatagramPacket dpGui = new DatagramPacket(msg.getBytes(), msg.length(), ip, port);
        socket.send(dpGui);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String s = new String(dpNhan.getData());
        s = s.replace(";", " ");
        s = s.replace(",", " ");
        String[] parts = s.trim().split("\\s+");
        String rqId = parts[0];
        int n = Integer.parseInt(parts[1]);
        int[] cnt = new int[10000005];
        for(int i = 2; i < parts.length; i++){
            cnt[Integer.parseInt(parts[i])]++;
        }
        String res = rqId + ";";
        for(int i = 1; i <= n; i++){
            if(cnt[i] == 0){
                res += i + ",";
            }
        }
        res = res.substring(0, res.length() - 1);
        
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), ip, port);
        socket.send(dpGui1);
        socket.close();
    }
}
