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
public class ByteStream_vitricb {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String msg = "B22DCCN822;zmNHK0Y7";
        
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
        int n = a.size(), pos = 0, res = Integer.MAX_VALUE, tongTrai = 0, tongPhai = 0;
        for(int i = 0; i < n - 1; i++){
            int x = 0, y = 0;
            for(int j = 0; j < i; j++){
                x += a.get(j);
            }
            for(int j = i; j < n; j++){
                y += a.get(j);
            }
            int hieu = Math.abs(x - y);
            if(hieu < res){
                res = hieu;
                pos = i;
                tongTrai = x;
                tongPhai = y;
            }
        }
        String ans = pos + "," + tongTrai + "," + tongPhai + "," + res;
        out.write(ans.getBytes());
        out.flush();
        
        socket.close();
    }
}
