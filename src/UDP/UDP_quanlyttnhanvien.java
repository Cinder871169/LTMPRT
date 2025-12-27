/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.net.*;
import java.io.*;

/**
 *
 * @author Admin
 */
public class UDP_quanlyttnhanvien {
    public static String chuanHoa(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    
    public static String chuanHoaTen(String s){
        String[] parts = s.trim().split("\\s+");
        String res = "";
        for(String i : parts){
            res += chuanHoa(i) + " ";
        }
        return res.trim();
    }
    
    public static String chuanHoaDate(String s){
        String[] parts = s.split("-");
        return parts[2] + "/" + parts[1] + "/" + parts[0];
    }
    
    public static double tangSalary(double a, String s){
        int sum = 0;
        for(char c : s.toCharArray()){
            sum += c - '0';
        }
        return a *(1.0 + sum/100);
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        String msg = ";B22DCCN822;ySsumsIE";
        
        DatagramPacket dpGui = new DatagramPacket(msg.getBytes(), msg.length(), ip, port);
        socket.send(dpGui);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String rqId = new String(dpNhan.getData(), 0, 8);
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength());
        ObjectInputStream in = new ObjectInputStream(bais);
        Employee e = (Employee) in.readObject();
        e.name = chuanHoaTen(e.name);
        String year = e.hireDate.substring(0, 4);
        e.salary = tangSalary(e.salary, year);
        e.hireDate = chuanHoaDate(e.hireDate);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(e);
        out.flush();
        
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(rqId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGui1 = new DatagramPacket(sendData, sendData.length, ip, port);
        socket.send(dpGui1);
        socket.close();
    }
}
