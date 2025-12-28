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
public class RMI_phantichthuasoNT {
    public static void main(String[] args) throws Exception{
        DataService sv = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
        int n = (Integer) sv.requestData("B22DCCN822", "zzmmquoc");
        List<Integer> a = new ArrayList<>();
        for(int i = 2; i <= Math.sqrt(n); i++){
            while(n % i == 0){
                a.add(i);
                n /= i;
            }
        }
        if(n > 1){
            a.add(n);
        }
        sv.submitData("B22DCCN822", "zzmmquoc", a);
    }
}
