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
public class RMI_quanlythuvien2 {
    public static void main(String[] args) throws Exception{
        ObjectService sv = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
        BookX b = (BookX) sv.requestObject("B22DCCN822", "CoWosBho");
        String code = "";
        String[] parts = b.author.split("\\s+");
        code += parts[0].charAt(0) + parts[parts.length - 1].charAt(0);
        code += String.format("%02d%d%d", b.yearPublished % 10, b.genre.length(), b.title.length() % 10);
        b.code = code;
        sv.submitObject("B22DCCN822", "CoWosBho", b);
    }
}
