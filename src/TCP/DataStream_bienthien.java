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
public class DataStream_bienthien {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String msg = "B22DCCN822;oNGj55wV";
        
        out.writeUTF(msg);
        out.flush();
        
        String s = in.readUTF();
        ArrayList<Integer> lst = new ArrayList<>();
        String[] nums = s.split(",");
        for(String i : nums){
            lst.add(Integer.parseInt(i));
        }
        int bienThien = 0, n = lst.size();
        for(int i = 0; i < n - 1; i++){
            bienThien += Math.abs(lst.get(i) - lst.get(i + 1));
        }
        int doiChieu = 0;
        for(int i = 1; i < n - 1; i++){
            if(lst.get(i) > lst.get(i - 1) && lst.get(i) > lst.get(i + 1) || lst.get(i) < lst.get(i - 1) && lst.get(i) < lst.get(i + 1)){
                doiChieu++;
            }
        }
        out.writeInt(doiChieu);
        out.writeInt(bienThien);
        out.flush();
        
        socket.close();
        
    }
}
