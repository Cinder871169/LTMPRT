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
public class RMI_quanlynhanvien {
    public static void main(String[] args) throws Exception{
        ObjectService sv = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
        Employee e = (Employee) sv.requestObject("B22DCCN822", "7fSWnlHB");
        int sum = 0, x = e.experienceYears, y = e.experienceYears;
        while(x > 0){
            sum += x % 10;
            x /= 10;
        }
        int soUoc = 0;
        for(int i = 1; i <= y; i++){
            if(y % i == 0){
                soUoc++;
            }
        }
        double factor = (double) ((e.experienceYears + sum + soUoc) / 100.0);
        double finalSalary =  e.baseSalary * (1 + factor);
        e.finalSalary = finalSalary;
        sv.submitObject("B22DCCN822", "7fSWnlHB", e);
    }
}
