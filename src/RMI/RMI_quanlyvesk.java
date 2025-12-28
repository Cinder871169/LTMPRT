/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.rmi.*;
import java.util.HashSet;
/**
 *
 * @author Admin
 */
public class RMI_quanlyvesk {
    public static void main(String[] args) throws Exception{
        ObjectService sv = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
        Ticket t = (Ticket) sv.requestObject("B22DCCN822", "Uct8bABt");
        String code = "";
        code += Character.toUpperCase(t.eventName.charAt(0)) + Character.toUpperCase(t.eventName.charAt(t.eventName.length() - 1));
        code += t.saleDate.substring(3, 5) + t.saleDate.substring(0, 2);
        HashSet<Integer> set = new HashSet<>();
        for(char i : t.saleDate.toCharArray()){
            if(Character.isDigit(i)){
                set.add(i - '0');
            }
        }
        for(int i = 9; i >= 0; i--){
            if(!set.contains(i)){
                code += i;
                break;
            }
        }
        for(int i = 0; i <= 9; i++){
            if(!set.contains(i)){
                code += i;
                break;
            }
        }
        t.ticketCode = code;
        sv.submitObject("B22DCCN822", "Uct8bABt", t);
    }
}
