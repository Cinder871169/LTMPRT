/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.rmi.*;
/**
 *
 * @author Admin
 */
public class RMI_doitien {
    public static void main(String[] args) throws Exception{
        DataService sv = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
        int n = (Integer) sv.requestData("B22DCCN822", "Iz06p8Zw");
        int[] a = {1, 2, 5, 10};
        String res = "";
        int cnt = 0;
        while(n > 0){
            for(int i = 3; i >= 0; i--){
                while(a[i] <= n){
                    cnt++;
                    res += a[i] + ",";
                    n -= a[i];
                }
            }
        }
        res = cnt + ";" + res.substring(0, res.length() - 1);
        sv.submitData("B22DCCN822", "Iz06p8Zw", res);
    }
}
