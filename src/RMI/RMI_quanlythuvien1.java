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
public class RMI_quanlythuvien1 {
    public static void main(String[] args) throws Exception{
        ObjectService sv = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
        Book b = (Book) sv.requestObject("B22DCCN822", "nCOdwcKJ");
        String code = "";
        String[] parts = b.author.split("\\s+");
        code += ("" + parts[0].charAt(0) + parts[parts.length - 1].charAt(0)).toUpperCase();
        code += String.format("%02d%d%03d", b.yearPublished % 100, b.title.trim().length(), b.pageCount);
        sv.submitObject("B22DCCN822", "nCOdwcKJ", b);
    }
}
