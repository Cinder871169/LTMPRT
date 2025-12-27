/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Admin
 */
public class UDP_tongbigint {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        String msg = ";B22DCCN822;2sIjAYaU";
        
        DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.length(), ip, port);
        socket.send(dp);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData());
        
        String[] parts = s.split(";");
        String rqId = parts[0];
        BigInteger a = new BigInteger(parts[1]);
        BigInteger b = new BigInteger(parts[2]);
        String tong = a.add(b).toString();
        String hieu = a.subtract(b).toString();
        String res = rqId + ";" + tong + ";" + hieu;
        
        DatagramPacket dpGui = new DatagramPacket(res.getBytes(), res.length(), ip, port);
        socket.send(dpGui);
        socket.close();
    }
}
