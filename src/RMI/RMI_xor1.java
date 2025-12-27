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
public class RMI_xor1 {
    public static void main(String[] args) throws Exception{
        CharacterService sv = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
        String s = sv.requestCharacter("B22DCCN822", "Xidb0Thk");
        String[] parts = s.split(";");
        String res = "";
        for(int i = 0; i < parts[1].length(); i++){
            res +=  (char) (parts[1].charAt(i) ^ parts[0].charAt(i % parts[0].length()));
        }
        sv.submitCharacter("B22DCCN822", "Xidb0Thk", res);
    }
}
