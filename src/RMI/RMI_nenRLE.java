/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.rmi.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class RMI_nenRLE {
    public static void main(String[] args) throws Exception{
        ByteService sv = (ByteService) Naming.lookup("rmi://203.162.10.109/RMIByteService");
        byte[] a = sv.requestData("B22DCCN822", "2uG0lQGi");
        int cnt = 1;
        ArrayList<Byte> res = new ArrayList<>();
        for(int i = 1; i < a.length; i++){
            if(a[i] == a[i - 1]){
                cnt++;
            } else {
                res.add(a[i - 1]);
                res.add((byte) cnt);
                cnt = 1;
            }
        }
        byte[] ans = new byte[res.size()];
        int index = 0;
        for(byte i : res){
            ans[index++] = i;
        }
        sv.submitData("B22DCCN822", "2uG0lQGi", ans);
    }
}
