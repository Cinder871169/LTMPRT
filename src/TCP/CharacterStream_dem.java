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
public class CharacterStream_dem {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String msg = "B22DCCN822;GJR8wC49";
        
        out.write(msg);
        out.newLine();
        out.flush();
        
        String s = in.readLine();
        int[] cnt = new int[256];
        
        for(char i : s.toCharArray()){
            cnt[i]++;
        }
        StringBuilder sb = new StringBuilder();
        for(char i : s.toCharArray()){
            if(cnt[i] > 1){
                sb.append(i).append(":").append(cnt[i]).append(",");
                cnt[i] = 0;
            }
        }
        out.write(sb.toString());
        out.newLine();
        out.flush();
        
        socket.close();
    }
}
