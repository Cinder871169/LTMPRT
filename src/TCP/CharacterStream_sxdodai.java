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
public class CharacterStream_sxdodai {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String msg = "B22DCCN822;we3kcWxZ";
        
        out.write(msg);
        out.newLine();
        out.flush();
        
        String s = in.readLine();
        String[] words = s.trim().split("\\s+");
        ArrayList<String> a = new ArrayList<>();
        for(String i : words){
            a.add(i);
        }
        int n = a.size();
        Collections.sort(a, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(sb.length() > 0){
                sb.append(", ");
            }
            sb.append(a.get(i));
        }
        
        out.write(sb.toString());
        out.newLine();
        out.flush();
        
        socket.close();
    }
}
