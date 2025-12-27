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
public class RMI_chuyendoihe8 {
    public static void main(String[] args) throws Exception{
        ByteService sv = (ByteService) Naming.lookup("rmi://203.162.10.109/RMIByteService");
        byte[] a = sv.requestData("B22DCCN822", "HhPAxeDw");
        String res = "";
        for(byte i : a){
            res += String.format("%03o", i & 0xFF);
        }
        byte[] ans = res.getBytes();
        sv.submitData("B22DCCN822", "HhPAxeDw", ans);
    }
}
