/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;

/**
 *
 * @author Admin
 */
public class ByteStream_chuoicontangdainhat {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        String msg = "B22DCCN798;P1iwlgG1";
        
        os.write(msg.getBytes());
        os.flush();
        byte[] buffer = new byte[1024];
        int len = is.read(buffer);
        String s = new String(buffer, 0, len);
 
        ArrayList<Integer> lst = new ArrayList<>();
        String[] parts = s.split(",");
        for(String i : parts){
            lst.add(Integer.parseInt(i));
        }
        int n = lst.size();
        int[] f = new int[n];
        int[] trace = new int[n];
        Arrays.fill(f, 1);
        Arrays.fill(trace, -1);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(lst.get(j) < lst.get(i) && f[i] < f[j] + 1){
                    f[i] = f[j] + 1;
                    trace[i] = j;
                }
            }
        }
        
        int maxLength = 0;
        int endIndex = 0;
        for(int i = 0; i < n; i++){
            if(maxLength < f[i]){
                maxLength = f[i];
                endIndex = i;
            }
        }
        
        ArrayList<Integer> lis = new ArrayList<>();
        while(endIndex != -1){
            lis.add(lst.get(endIndex));
            endIndex = trace[endIndex];
        }
        Collections.reverse(lis);
        
        StringBuilder sb = new StringBuilder();
        for(Integer i : lis){
            sb.append(i).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(";").append(lis.size());
        
        os.write(sb.toString().getBytes());
        os.flush();
         
        socket.close();
    }
}
