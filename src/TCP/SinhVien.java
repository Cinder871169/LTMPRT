/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class SinhVien {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        String msg = "B22DCCN822;j5ELZdmS";
        
        out.writeObject(msg);
        out.flush();
        
        Student s = (Student) in.readObject();
        float gpa = s.getGpa();
        if(gpa >= 3.7) s.setGpaLetter("A");
        else if(gpa >= 3.0) s.setGpaLetter("B");
        else if(gpa >= 2.0) s.setGpaLetter("C");
        else if(gpa >= 1.0) s.setGpaLetter("D");
        else s.setGpaLetter("F");
        
        out.writeObject(s);
        out.flush();
        
        socket.close();
    }
}
