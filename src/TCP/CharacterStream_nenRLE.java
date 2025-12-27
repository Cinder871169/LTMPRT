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
import java.util.*;
/**
 *
 * @author Admin
 */
public class CharacterStream_nenRLE {
    public static String reverseString(String s){
        return new StringBuilder(s).reverse().toString();
    }
    
    public static String rle(String rev){
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for(int i = 1; i < rev.length(); i++){
            if(rev.charAt(i) == rev.charAt(i - 1)){
                cnt++;
            } else {
                sb.append(rev.charAt(i - 1));
                if(cnt > 1) sb.append(cnt);
                cnt = 1;
            }
        }
        sb.append(rev.charAt(rev.length() - 1));
        if(cnt > 1){
            sb.append(cnt);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String msg = "B22DCCN822;ji3fQD3Q";
        
        out.write(msg);
        out.newLine();
        out.flush();
        
        String s = in.readLine();
        StringBuilder sb = new StringBuilder();
        String[] parts = s.split("\\s+");
        for(String i : parts){
            if(sb.length() > 0){
                sb.append(" ");
            }
            sb.append(rle(reverseString(i)));
        }
        
        out.write(sb.toString());
        out.newLine();
        out.flush();
        
        socket.close();
        
    }
}
