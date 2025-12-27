/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class CharacterStream_loaibonguyenam {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String msg = "B22DCCN822;x8c45mq";
        
        out.write(msg);
        out.newLine();
        out.flush();
        
        String s = in.readLine();
        String res = "";
        for(char x : s.toCharArray()){
            if(x != 'u' && x != 'e' && x != 'o' && x != 'a' && x != 'i'){
                res += x;
            }
        }
        out.write(res);
        out.newLine();
        out.flush();
        
        socket.close();
    }
}
