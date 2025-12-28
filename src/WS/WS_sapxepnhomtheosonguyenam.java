/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;
import java.util.*;
import vn.medianews.*;
/**
 *
 * @author Admin
 */
public class WS_sapxepnhomtheosonguyenam {
    public static int count(String s){
        int cnt = 0;
        String a = "ueoaiUEOAI";
        for(int i = 0; i < s.length(); i++){
            if(a.indexOf(s.charAt(i)) != -1){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception{
        String studentCode = "B22DCCN822", qCode = "mDN1MFUJ";
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService p = sv.getCharacterServicePort();
        Map<String, Integer> mp = new HashMap<>();
        List<String> a = p.requestStringArray(studentCode, qCode);
        for(String i : a){
            mp.put(i, count(i));
        }
        Collections.sort(a, (String s1, String s2) -> {
            int c1 = mp.get(s1), c2 = mp.get(s2);
            if(c1 != c2){
                return c1 - c2;
            }
            return s1.compareTo(s2);
        });
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(a.get(0));
        for(int i = 1; i < a.size(); i++){
            if(mp.get(i) == mp.get(i - 1)){
                sb.append(", ").append(a.get(i));
            } else{
                res.add(sb.toString());
                sb = new StringBuilder(a.get(i));
            }
        }
        res.add(sb.toString());
        p.submitCharacterStringArray(studentCode, qCode, res);
    }
}
