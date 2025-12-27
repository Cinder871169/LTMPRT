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
public class RMI_hoanviketiep {
    public static void main(String[] args) throws Exception{
        DataService sv = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
        String s = (String) sv.requestData("B22DCCN822", "3Qe0Qb5w");
        s= s.replace(",", " ");
        String[] parts = s.split("\\s+");
        ArrayList<Integer> a = new ArrayList<>();
        for(String i : parts){
            a.add(Integer.parseInt(i));
        }
        int n = a.size();
        int i = n - 2;
        while(i >= 0 && a.get(i) > a.get(i + 1)){
            i--;
        }
        if(i < 0){
            Collections.sort(a);
        }
        int j = n - 1;
        while(a.get(j) < a.get(i)){
            j--;
        }
        Collections.swap(a, i, j);
        int l = i + 1, r = n - 1;
        while(l < r){
            Collections.swap(a, l, r);
            l++;
            r--;
        }
        String res = "";
        for(int x : a){
            res += x + ",";
        }
        res = res.substring(0, res.length() - 1);
        sv.submitData("B22DCCN822", "3Qe0Qb5w", res);
    }
}
