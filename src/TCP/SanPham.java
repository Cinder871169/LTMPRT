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
public class SanPham {
    public static String chuanHoaTen(String s){
        String[] parts = s.split("\\s+");
        String tmp = parts[0];
        parts[0] = parts[parts.length - 1];
        parts[parts.length - 1] = tmp;
        return String.join(" ", parts);
    }
    public static int chuanHoaSoLuong(int n){
        String s = String.valueOf(n);
        String x = new StringBuilder(n).reverse().toString();
        return Integer.parseInt(x);
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        String msg = "B22DCCN822;PoFyczA9";
        
        out.writeObject(msg);
        out.flush();
        
        Product p = (Product) in.readObject();
        p.setName(chuanHoaTen(p.getName()).trim());
        p.setQuantity(chuanHoaSoLuong(p.getQuantity()));
        
        out.writeObject(p);
        out.flush();
        
    }
}
