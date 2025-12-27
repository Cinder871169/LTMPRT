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
public class RMI_demsolanxh1 {
    public static void main(String[] args) throws Exception{
        CharacterService sv = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
        String s = sv.requestCharacter("B22DCCN822", "U5BEBBOW");
        int[] cnt = new int[256];
        for(char c : s.toCharArray()){
            cnt[c]++;
        }
        String res = "";
        for(char i : s.toCharArray()){
            if(cnt[i] > 0){
                res += i + cnt[i];
                cnt[i] = 0;
            }
        }
        sv.submitCharacter("B22DCCN822", "U5BEBBOW", res);
    }
}
