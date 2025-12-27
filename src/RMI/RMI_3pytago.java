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
public class RMI_3pytago {
    public static void main(String[] args) throws Exception{
        DataService sv = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
        int n = (int) sv.requestData("B22DCCN822", "NMATI6Zw");
        List<List<Integer>> res = new ArrayList<>();
//        for(int i = 1; i <= n; i++){
//            for(int j = i + 1; j <= n; j++){
//                for(int k = j + 1; k <= n; k++){
//                    if(i * i + j * j == k * k){
//                        List<Integer> lst = new ArrayList<>();
//                        lst.add(i);
//                        lst.add(j);
//                        lst.add(k);
//                        res.add(lst);
//                    }
//                }
//            }
//        }
        for(int c = 3; c <= n; c++){
            for(int a = 1; a < c; a++){
                int b2 = c * c - a * a;
                int b = (int) Math.sqrt(b2);
                if(b > a && b < c && b * b == b2){
                    res.add(Arrays.asList(a, b, c));
                }
            }   
        }
        sv.submitData("B22DCCN822", "NMATI6Zw", res);
    }
}
