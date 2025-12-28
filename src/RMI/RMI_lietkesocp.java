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
public class RMI_lietkesocp {
    public static boolean check(int x){
        double k = Math.sqrt(x);
        return k * k == x;
    }
    public static void main(String[] args) throws Exception{
        DataService sv = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
        int n = (Integer) sv.requestData("B22DCCN822", "eTHcAYZh");
        List<Integer> a = new ArrayList<>();
        for(int i = 1; i < n; i++){
            if(check(i)){
                a.add(i);
            }
        }
        sv.submitData("B22DCCN822", "eTHcAYZh", a);
    }
}
