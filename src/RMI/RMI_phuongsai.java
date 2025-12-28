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
public class RMI_phuongsai {
    public static void main(String[] args) throws Exception{
        DataService sv = (DataService) Naming.lookup("rmi://203.162.10.109/RMiByteService");
        String s = (String) sv.requestData("B22DCCN822", "uZMEY3Zg");
        s = s.replace(",", " ");
        String[] parts = s.split("\\s+");
        ArrayList<Double> a = new ArrayList<>();
        for(String i : parts){
            a.add(Double.parseDouble(i));
        }
        int n = a.size();
        double sum = 0;
        for(Double i : a){
            sum += i;
        }
        double tbc = sum / (double) n;
        double tmp = 0;
        for(Double i : a){
            tmp += (i - tbc) * (i - tbc);
        }
        double phuongSai = tmp / n;
        double doLechChuan = Math.sqrt(phuongSai);
        String res = String.format("%.2f : %.2f", phuongSai, doLechChuan);
        sv.submitData("B22DCCN822", "uZMEY3Zg", res);
    }
}
