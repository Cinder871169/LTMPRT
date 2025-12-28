/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;
import vn.medianews.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class WS_phantichTSNT {
    public static void main(String[] args) throws Exception{
        DataService_Service sv = new DataService_Service();
        DataService p = sv.getDataServicePort();
        String studentCode = "B22DCCN822", qCode = "TwZpbqUg";
        List<Integer> a = p.getData(studentCode, qCode);
        List<String> res = new ArrayList<>();
        for(int n : a){
            StringBuilder sb = new StringBuilder();
            for(int i = 2; i <= Math.sqrt(n); i++){
                while(n % i == 0){
                    if(sb.length() > 0){
                        sb.append(", ");
                    }
                    sb.append(i);
                    n /= i;
                }
            }
            if(n > 1){
                sb.append(", ").append(n);
            }
            res.add(sb.toString());
        }
        p.submitDataStringArray(studentCode, qCode, res);
    }
}
