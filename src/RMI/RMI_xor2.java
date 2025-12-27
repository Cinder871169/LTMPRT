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
public class RMI_xor2 {
    public static void main(String[] args) throws Exception{
        ByteService sv = (ByteService) Naming.lookup("rmi://203.162.10.109/RMIByteService");
        byte[] a = sv.requestData("B22DCCN822", "4BraNTI5");
        String s = "PTIT";
        byte[] key = s.getBytes();
        byte[] res = new byte[a.length];
        for(int i = 0; i < a.length; i++){
            res[i] = (byte) (a[i] ^ key[i % key.length]);
        }
        sv.submitData("B22DCCN822", "4BraNTI5", res);
    }
}
