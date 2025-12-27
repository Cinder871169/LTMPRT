/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class DataStream_hcs816 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String msg = "B22DCCN822;0LTGyX4p";
        
        out.writeUTF(msg);
        out.flush();
        
        int n = in.readInt();
        String oct = Integer.toOctalString(n);
        String hex = Integer.toHexString(n);
        String res = oct + ";" + hex;
        
        out.writeUTF(res);
        out.flush();
        
        socket.close();
    }
}
