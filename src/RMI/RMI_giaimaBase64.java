/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.rmi.*;
import java.util.Base64;
/**
 *
 * @author Admin
 */
public class RMI_giaimaBase64 {
    public static void main(String[] args) throws Exception{
        ByteService sv = (ByteService) Naming.lookup("rmi://203.162.10.109/RMIByteService");
        byte[] a = sv.requestData("B22DCCN822", "oeJljCIf");
        String s = new String(a);
        byte[] res = Base64.getDecoder().decode(s);
        sv.submitData("B22DCCN822", "oeJljCIf", res);
    }
}
