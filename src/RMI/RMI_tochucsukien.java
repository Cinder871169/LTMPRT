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
public class RMI_tochucsukien {
    public static void main(String[] args) throws Exception {
        ObjectService sv = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
        Event e = (Event) sv.requestObject("B22DCCN822", "FKrGvwLM");
        String code = "";
        if(e.expectedAttendance >= 1000){
            code += "L";
        } else if(e.expectedAttendance >= 500){
            code += "M";
        } else {
            code += "S";
        }
        String[] parts = e.eventName.split("\\s+");
        code += Character.toUpperCase(parts[0].charAt(0));
        code += Character.toUpperCase(parts[parts.length - 1].charAt(0));
        code += e.eventDate.substring(8, 10) + e.eventDate.substring(5, 7);
        e.eventCode = code;
        sv.submitObject("B22DCCN822", "FKrGvwLM", e);
    }
}
