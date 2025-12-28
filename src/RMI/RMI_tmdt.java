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
public class RMI_tmdt {
    public static void main(String[] args) throws Exception{
        ObjectService sv = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
        Order o = (Order) sv.requestObject("B22DCCN822", "vLJWvWpf");
        o.orderCode = o.shippingType.substring(0, 2).toUpperCase() + o.customerCode.substring(o.customerCode.length() - 3) + o.orderDate.substring(8, 10) + o.orderDate.substring(5, 7);
        sv.submitObject("B22DCCN822", "vLJWvWpf", o);
    }
}
