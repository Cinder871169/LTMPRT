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
public class RMI_mahoacaesar1 {
    public static void main(String[] args) throws Exception{
        CharacterService sv = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
        String s = sv.requestCharacter("B22DCCN822", "j4rStb2a");
        int shift = s.length() % 7;
        String res = "";
        for(char i : s.toCharArray()){
            if(Character.isUpperCase(i)){
                res += (char) (i - shift - 'A' + 26) % 26 + 'A'; 
            }else {
                res += (char) (i - shift - 'a' + 26) % 26 + 'a';
            }
        }
        sv.submitCharacter("B22DCCN822", "j4rStb2a", res);
    }
}
