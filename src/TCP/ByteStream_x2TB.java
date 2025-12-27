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
public class ByteStream_x2TB {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String msg = "B22DCCN822;TL9Pol9D";
        
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
        Collections.sort(a);
        int tong = 0, n = a.size();
        for(int i = 0; i < n; i++){
            tong += a.get(i);
        }
        float tb = (float) tong/n;
        float kc = Float.MAX_VALUE, k = 2 * tb;
        int x = 0, y = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                float hieu = Math.abs(a.get(i) + a.get(j) - k);
                if(hieu < kc){
                    kc = hieu;
                    x = a.get(i);
                    y = a.get(j);
                }
            }
        }
        String res = x + "," + y;
        out.write(res.getBytes());
        out.flush();
        
        socket.close();
    }
}
