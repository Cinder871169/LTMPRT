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
public class RMI_mahoavigenere {
    public static void main(String[] args) throws Exception{
        CharacterService sv = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
        String s = sv.requestCharacter("B22DCCN822", "Y7YMXHs4");
        String[] parts = s.split(";");
        String key = parts[0], text = parts[1];
        String res = "";
        for(int i = 0; i < text.length(); i++){
            char x = text.charAt(i), y = key.charAt(i % key.length());
            if(Character.isUpperCase(x)){
                res += (char) ((x - 'A' + y - 'A') % 26 + 'A');
            } else {
                res += (char) ((x - 'a' + y - 'a') % 26 + 'a');
            }
        }
        sv.submitCharacter("B22DCCN822", "Y7YMXHs4", res);
    }
}
