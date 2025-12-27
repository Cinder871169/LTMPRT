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
public class RMI_phantuxhnhieunhat {
    public static void main(String[] args) throws Exception{
        ByteService sv = (ByteService) Naming.lookup("rmi://203.162.10.109/RMIByteService");
        byte[] a = sv.requestData("B22DCCN822", "1mPMIkGJ");
        int[] cnt = new int[256];
        for(byte i : a){
            cnt[i]++;
        }
        byte MAX = a[0];
        int maxCount = cnt[MAX];
        for(byte i : a){
            if (cnt[i] > maxCount){
                MAX = i;
                maxCount = cnt[i];
            }
        }
        byte[] res = {MAX, (byte) maxCount};
        sv.submitData("B22DCCN822", "1mPMIkGJ", res);
    }
}
