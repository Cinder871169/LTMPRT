/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

/**
 *
 * @author Admin
 */
public class ByteStream_chuoi {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String msg = "B22DCCN822;knkRC50U";
        
        out.write(msg.getBytes());
        out.flush();
        
        byte[] buffer = new byte[1024];
        int len = in.read(buffer);
        String s = new String(buffer, 0, len);
        
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(s);
        int cnt = 1;
        sb.append(n);
        while(n != 1){
            if(n % 2 == 0){
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            sb.append(" ").append(n);
            cnt++;
        }
        sb.append("; ").append(cnt);
        out.write(sb.toString().getBytes());
        out.flush();
    }
}
