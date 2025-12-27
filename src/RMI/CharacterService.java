/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RMI;

import java.rmi.*;

/**
 *
 * @author Admin
 */
public interface CharacterService extends Remote{
    public String requestCharacter(String studentCode, String qCode)throws RemoteException;
    public void submitCharacter(String studentCode, String qCodeString, String strSubmit) throws RemoteException;
}
