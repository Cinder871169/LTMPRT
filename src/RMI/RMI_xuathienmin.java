/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.rmi.*;
/**
 *
 * @author Admin
 */
public class RMI_xuathienmin {
    public static void main(String[] args) throws Exception{
        ByteService sv = (ByteService) Naming.lookup("rmi://203.162.10.109/RMIByteService");
        byte[] a = sv.requestData("B22DCCN822", "L7A2NPQU");
        int cnt[] = new int[256];
        for(byte i : a){
            cnt[i]++;
        }
        byte MIN = a[0];
        int minCount = cnt[a[0]];
        for(byte i : a){
            if(i < MIN){
                MIN = i;
                minCount = cnt[i];
            }
        }
        byte[] res = {MIN, (byte) minCount};
        sv.submitData("B22DCCN822", "L7A2NPQU", res);
    }
}
