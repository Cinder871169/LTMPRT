/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class DataStream_caesar {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String msg = "B22DCCN822;in6p3nPd";
        
        out.writeUTF(msg);
        out.flush();
        
        String s = in.readUTF();
        int k = in.readInt();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isUpperCase(c)){
                c = (char) ((c - 'A' - k + 26) % 26 + 'A');
            } else if (Character.isLowerCase(c)){
                c = (char) ((c - 'a' - k + 26) % 26 + 'a');
            }
            sb.append(c);
        }
        
        out.writeUTF(sb.toString());
        socket.close();
    }
}
