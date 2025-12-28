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
public class RMI_chuyendoilama {
    public static int trans (char c){
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            default:
                break;
        }
        return 1000;
    }
    
    public static long convert(String s){
        long sum = 0;
        sum += trans(s.charAt(s.length() - 1));
        for(int i = s.length() - 2; i >= 0; i--){
            if(trans(s.charAt(i)) < trans(s.charAt(i + 1))){
                sum -= trans(s.charAt(i));
            } else{
                sum += trans(s.charAt(i));
            }
        }
        return sum;
    }
    public static void main(String[] args) throws Exception{
        CharacterService sv = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
        String s = sv.requestCharacter("B22DCCN822", "0JaasIw6");
        sv.submitCharacter("B22DCCN822", "0JaasIw6", String.valueOf(convert(s)));
    }
}
