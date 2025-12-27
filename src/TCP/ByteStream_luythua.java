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
public class ByteStream_luythua {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String msg = "B22DCCN822;nxMRj8z";
        
        byte[] buffer = new byte[1024];
        int len = in.read(buffer);
        String s = new String(buffer, 0, len);
        String[] parts = s.split("\\|");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        int res = (int) Math.pow(x, y);
        
        out.write(String.valueOf(res).getBytes());
        out.flush();
        socket.close();
    }
}
