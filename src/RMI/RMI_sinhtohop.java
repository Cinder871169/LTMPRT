/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.util.*;
import java.rmi.*;
/**
 *
 * @author Admin
 */
public class RMI_sinhtohop {
    static int ok;
    public static void init(int a[], int k){
        for(int i = 1; i <= k; i++){
            a[i] = i;
        }
    }
    
    public static void sinh(int a[], int n, int k){
        int i = k;
        while(i >= 1 && a[i] == n - k + i){
            i--;
        }
        if(i == 0){
            ok = 0;
        } else {
            a[i]++;
            for(int j = i + 1; j <= k; j++){
                a[j] = a[j - 1] + 1;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        DataService sv = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
        String s = (String) sv.requestData("B22DCCN822", "juC3u7C6");
        String[] parts = s.split(";");
        int k = Integer.parseInt(parts[1].trim());
        String[] tmp = parts[0].split(",");
        ArrayList<Integer> a = new ArrayList<>();
        for(String i : tmp){
            a.add(Integer.parseInt(i.trim()));
        }
        
        int n = a.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[] index = new int[k + 1];
        init(index, k);
        ok = 1;
        
        while(ok == 1){
            ArrayList<Integer> lst = new ArrayList<>();
            for(int i = 1; i <= k; i++){
                lst.add(a.get(index[i] - 1));
            }
            res.add(lst);
            sinh(index, n, k);
        }
        sv.submitData("B22DCCN822", "juC3u7C6", res);
    }
}
