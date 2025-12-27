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
public class SanPham_1 {
    public static void main(String[] args) throws Exception{
        ObjectService sv = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
        Product s = (Product) sv.requestObject("B22DCCN822", "dx3nt4Ij");
        s.code = s.code.toUpperCase();
        s.exportPrice = s.importPrice*1.2;
        sv.submitObject("B22DCCN822", "dx3nt4Ij", s);
    }
}
