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
public class SanPham_2 {
    public static void main(String[] args) throws Exception{
        ObjectService sv = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
        ProductX p = (ProductX) sv.requestObject("B22DCCN822", "PY43T66m");
        String s = p.discountCode;
        int sum = 0;
        for(char i : s.toCharArray()){
            sum += i - '0';
        }
        p.discount = sum;
        sv.submitObject("B22DCCN822", "PY43T66m", p);
    }
}
