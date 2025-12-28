/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.rmi.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class RMI_palindromenumbers {
    public static boolean check(int n){
        String s = n + "";
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        DataService sv = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
        String s = (String) sv.requestData("B22DCCN822", "t3cBY2uk");
        String[] parts = s.split(";");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        List<Integer> a = new ArrayList<>();
        for(int i = n; i < k; i++){
            if(check(i)){
                a.add(i);
            }
        }
        sv.submitData("B22DCCN822", "t3cBY2uk", a);
    }
}
