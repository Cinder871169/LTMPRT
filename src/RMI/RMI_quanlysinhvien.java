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
public class RMI_quanlysinhvien {
    public static String chuanHoa(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    
    public static String chuanHoaTen(String s){
        String[] parts = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < parts.length - 1; i++){
            sb.append(chuanHoa(parts[i])).append(" ");
        }
        sb.append(parts[parts.length - 1].toUpperCase());
        return sb.toString();
    }
    public static void main(String[] args) throws Exception{
        ObjectService sv = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
        Student s = (Student) sv.requestObject("B22DCCN822", "lNV6xzmk");
        s.name = chuanHoaTen(s.name);
        String code = "B" + String.format("%02d", s.enrollmentYear % 100);
        String[] parts = s.name.split("\\s+");
        code += parts[parts.length - 1] + "_";
        for(int i = 0; i < parts.length - 1; i++){
            code += parts[i].charAt(0);
        }
        s.code = code;
        sv.submitObject("B22DCCN822", "lNV6xzmk", s);
    }
}
