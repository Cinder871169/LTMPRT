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
public class DataStream_uclnbcnn {
    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 1605);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String msg = "B22DCCN822;i9VhkNb";
        
        out.writeUTF(msg);
        out.flush();
        
        int a = in.readInt();
        int b = in.readInt();
        
        int gcd = gcd(a, b);
        int lcm = a * b/gcd;
        
        out.writeInt(gcd);
        out.writeInt(lcm);
        out.flush();
        
        socket.close();
        
    }
}
