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
public class RMI_lonthuk {
    public static void main(String[] args) throws Exception{
        DataService sv = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
        String s = (String) sv.requestData("B22DCCN822", "wzG6G9ji");
        String[] parts = s.split(";");
        String[] nums = parts[0].split(",");
        int k = Integer.parseInt(parts[1]);
        ArrayList<Integer> a = new ArrayList<>();
        for(String i : nums){
            a.add(Integer.parseInt(i.trim()));
        }
        Collections.sort(a);
        int res = a.get(a.size() - k);
        sv.submitData("B22DCCN822", "wzG6G9ji", res);
    }
}
