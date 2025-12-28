/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.net.URLEncoder;
import java.rmi.*;
/**
 *
 * @author Admin
 */
public class RMi_mahoaURL {
    public static void main(String[] args) throws Exception{
        CharacterService sv = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
        String s = sv.requestCharacter("B22DCCN822", "KkihaRAB");
        String res = URLEncoder.encode(s, "UTF-8").replace("+", "%20");
        sv.submitCharacter("B22DCCN822", "KkihaRAB", res);
    }
}
