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
public class RMI_mahoaBase64 {
    public static void main(String[] args) throws Exception{
        CharacterService sv = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
        String s = sv.requestCharacter("B22DCCN822", "psd4Jmnt");
        byte[] res = Base64.getEncoder().encode(s.getBytes());
        String ans = new String(res);
        sv.submitCharacter("B22DCCN822", "psd4Jmnt", ans);
    }
}
