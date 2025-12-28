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
public class RMI_sapxepchanle {
    public static void main(String[] args) throws Exception{
        ByteService sv = (ByteService) Naming.lookup("rmi://203.162.10.109/RMIByteService");
        byte[] a = sv.requestData("B22DCCN822", "A7hytb1V");
        int index = 0;
        byte[] res = new byte[a.length];
        for(byte i : a){
            if(i % 2 == 0){
                res[index++] = i;
            }
        }
        for(byte i : a){
            if(i % 2 == 1){
                res[index++] = i;
            }
        }
        sv.submitData("B22DCCN822", "A7hytb1V", res);
    }
}
