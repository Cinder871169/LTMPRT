/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ByteStream_tong_chuoi {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        
        String msg = "B22DCCN762;j4H65Lt3";
        os.write(msg.getBytes());
        os.flush();
        
        byte[] buffer = new byte[1024];
        int len = is.read(buffer);
        String s = new String(buffer, 0, len);
        System.out.println(s);
        
        String[] nums  = s.split("\\|");
        int sum = 0;
        for(String n : nums){
            sum += Integer.parseInt(n);
        }
        String res = String.valueOf(sum);
        os.write(res.getBytes());
        os.flush();
        
        is.close();
        os.close();
        socket.close();
    }
}
