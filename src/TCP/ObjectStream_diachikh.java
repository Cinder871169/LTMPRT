/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ObjectStream_diachikh {
    public static String clean(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isAlphabetic(c) || Character.isDigit(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static String chuanHoaTu(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanHoaDiaChi(String s){
        String[] parts = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String i : parts){
            if(sb.length() > 0){
                sb.append(" ");
            }
            sb.append(chuanHoaTu(clean(i)));
        }
        return sb.toString();
    }
    
    public static String chuanHoaPostalCode(String s){
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c) || c == '-') res.append(c);
        }
        return res.toString();
    }
    
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        String msg = "B22DCCN822;XtWjagNp";
        
        out.writeObject(msg);
        out.flush();
        
        Address a = (Address) in.readObject();
        a.setAddressLine(chuanHoaDiaChi(a.getAddressLine()));
        a.setPostalCode(chuanHoaPostalCode(a.getPostalCode()));
        
        out.writeObject(a);
        out.flush();
        
        socket.close();
    }
}
