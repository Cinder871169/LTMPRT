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
public class RMI_lietkeSNT {
    public static boolean prime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        DataService sv = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
        int n = (Integer) sv.requestData("B22DCCN822", "nD8MdtME");
        List<Integer> lst = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(prime(i)){
                lst.add(i);
            }
        }
        sv.submitData("B22DCCN822", "nD8MdtME", lst);
    }
}
