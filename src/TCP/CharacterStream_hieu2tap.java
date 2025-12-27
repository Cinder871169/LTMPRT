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
public class CharacterStream_hieu2tap {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String msg = "B22DCCN822;wWTzyRuY";
        
        out.write(msg);
        out.newLine();
        out.flush();
        
        String s1 = in.readLine();
        String s2 = in.readLine();
        
        String res = "";
        int[] cnt = new int[256];
        for(char c : s2.toCharArray()){
            cnt[c]++;
        }
        for(char c : s1.toCharArray()){
            if(cnt[c] == 0){
                res += c;
            }
        }
        
        out.write(res);
        out.newLine();
        out.flush();
        socket.close();
    }
}
