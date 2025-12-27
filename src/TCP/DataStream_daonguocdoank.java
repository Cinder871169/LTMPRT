/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;

/**
 *
 * @author Admin
 */
public class DataStream_daonguocdoank {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String msg = "B22DCCN001;dCNDHojG";
        
        out.writeUTF(msg);
        out.flush();
        
        int k = in.readInt();
        String s = in.readUTF();
        String[] nums = s.split(",");
        ArrayList<Integer> lst = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(String i : nums){
            lst.add(Integer.parseInt(i.trim()));
        }
        int n = lst.size();
        for(int i = 0; i < n; i += k){
            int j = Math.min(i + k - 1, n - 1);
            for(int m = j; m >= i; m--){
                res.add(lst.get(m));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(sb.length() > 0){
                sb.append(",");
            }
            sb.append(res.get(i));
        }
        out.writeUTF(sb.toString());
        out.flush();
        socket.close();
    }
}
