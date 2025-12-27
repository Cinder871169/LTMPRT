/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class KhachHang {
    public static String chuanHoaTen(String s){
        String[] parts = s.split("\\s+");
        String res = "";
        res += parts[s.length() - 1].toUpperCase() + ", ";
        for(int i = 0; i < s.length() - 1; i++){
            res += Character.toUpperCase(parts[i].charAt(0)) + parts[i].substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }
    
    public static String chuanHoaNs(String s){
        String[] parts = s.split("-");
        return parts[1] + "/" + parts[0] + "/" + parts[2];
    }
    
    public static String taoUserName(String s){
        String[] parts = s.split("\\s+");
        String res = "";
        for(int i = 0; i < parts.length - 1; i++){
            res += Character.toLowerCase(parts[i].charAt(0));
        }
        res += parts[s.length() - 1].toLowerCase();
        return res;
    }
    
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        String msg = "B22DCCN822;6Tw3qHNF";
        
        out.writeObject(msg);
        out.flush();
        
        Customer c = (Customer) in.readObject();
        c.setName(chuanHoaTen(c.getName()));
        c.setDayOfBirth(chuanHoaNs(c.getDayOfBirth()));
        c.setUserName(taoUserName(c.getName()));
        out.writeObject(c);
        out.flush();
        
    }
}
