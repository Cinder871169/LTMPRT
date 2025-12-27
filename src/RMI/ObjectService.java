/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RMI;
import java.io.Serializable;
import java.rmi.*;
/**
 *
 * @author Admin
 */
public interface ObjectService {
    public Serializable requestObject(String studentCodeString, String qAlias) throws RemoteException;
    public void submitObject(String studentCodeString, String qAlias, Serializable object) throws RemoteException;
}
