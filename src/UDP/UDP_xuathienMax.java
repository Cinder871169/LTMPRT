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
public class UDP_xuathienMax {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        String msg = ";B22DCCN822;CvlqJmaa";
        
        DatagramPacket dpGui = new DatagramPacket(msg.getBytes(), msg.length(), ip, port);
        socket.send(dpGui);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String s = new String(dpNhan.getData());
        String[] parts = s.trim().split(";");
        String rqId = parts[0];
        int[] cnt = new int[1000];
        for(char c : parts[1].toCharArray()){
            cnt[c]++;
        }
        int MAX = -1;
        char res = ' ';
        for(char c : parts[1].toCharArray()){
            if(cnt[c] > MAX){
                res = c;
                MAX = cnt[c];
            }
        }
        String ans = rqId + ";" + res + ":";
        for(int i = 0; i < parts[1].length(); i++){
            if(parts[1].charAt(i) == res){
                ans += (i + 1) + ",";
            }
        }
        
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), ip, port);
        socket.send(dpGui1);
        socket.close();
    }
}
