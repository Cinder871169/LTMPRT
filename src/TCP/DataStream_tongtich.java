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
public class DataStream_tongtich {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String msg = "B22DCCN798;wMurQJVB";
        
        out.writeUTF(msg);
        out.flush();
        
        int a = in.readInt();
        int b = in.readInt();
        
        out.writeInt(a + b);
        out.writeInt(a * b);
        out.flush();
        
        socket.close();
    }
}
