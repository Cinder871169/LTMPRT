/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Admin
 */
public class UDP_chuanhoathongtinsach{
    public static String chuanHoa(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    
    public static String chuanHoaTitle(String s){
        String[] parts = s.trim().split("\\s+");
        String res = "";
        for(String i : parts){
            res += chuanHoa(i) + " ";
        }
        return res.trim();
    }
    
    public static String chuanHoaTen(String s){
        String[] parts = s.trim().split("\\s+");
        String res = parts[0].toUpperCase() + ",";
        for(int i = 1; i < parts.length; i++){
            res += chuanHoa(parts[i]) + " ";
        }
        return res.trim();
    }
    
    public static String chuanHoaISBN(String s){
        return s.substring(0,3) + "-" + s.substring(3,4) + "-" + s.substring(4, 6) + "-" + s.substring(6,12) + "-" + s.substring(12);
    }
    
    public static String chuanHoaPublishDate(String s){
        String[] parts = s.split("-");
        return parts[1] + "/" + parts[0];
    }
    
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        String msg = ";B22DCCN822;LFACr5Bi";
        
        DatagramPacket dpGui = new DatagramPacket(msg.getBytes(), msg.length(), ip, port);
        socket.send(dpGui);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String rqId = new String(buffer, 0, 8);
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream in = new ObjectInputStream(bais);
        Book b = (Book) in.readObject();
        b.author = chuanHoaTen(b.author);
        b.title = chuanHoaTitle(b.title);
        b.isbn = chuanHoaISBN(b.isbn);
        b.publishDate = chuanHoaPublishDate(b.publishDate);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(b);
        out.flush();
        
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(rqId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 0, baos.size());
        DatagramPacket dpGui1 = new DatagramPacket(sendData, sendData.length, ip, port);
        socket.send(dpGui1);
        socket.close();
        
    }
}
