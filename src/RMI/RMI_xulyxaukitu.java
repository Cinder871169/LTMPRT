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
public class RMI_xulyxaukitu {
    public static void main(String[] args) throws Exception{
        CharacterService sv = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
        String s = sv.requestCharacter("B22DCCN822", "NFldNPp6");
        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] parts = s.split(",");
        String chan = "", le = "";
        for(int i = 0; i < parts.length; i++){
            if(i % 2 == 0){
                if(chan.length() > 0){
                    chan += ", ";
                }
                chan += parts[i];
            } else{
                if(le.length() > 0){
                    le += ", ";
                }
                le += parts[i];
            }
        }
        String res = chan + "; " + le;
        sv.submitCharacter("B22DCCN822", "NFldNPp6", res);
    }
}
