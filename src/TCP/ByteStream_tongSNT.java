/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;

/**
 *
 * @author Admin
 */
public class ByteStream_tongSNT {
    
    public static boolean prime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return n > 1;
    }
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String msg = "B22DCCN822;ZRFRsEcM";
        
        out.write(msg.getBytes());
        out.flush();
        
        byte[] buffer = new byte[1024];
        int len = in.read(buffer);
        String s = new String(buffer, 0, len);
        ArrayList<Integer> a = new ArrayList<>();
        String[] nums = s.split(",");
        for(String i : nums){
            a.add(Integer.parseInt(i.trim()));
        }
        int sum = 0;
        for(Integer i : a){
            if(prime(i)){
                sum += i;
            }
        }
        String res = String.valueOf(sum);
        out.write(res.getBytes());
        out.flush();
        
        socket.close();
    }
}
