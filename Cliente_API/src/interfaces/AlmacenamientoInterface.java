/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException ;

/**
 *
 * @author kachu
 */
public interface AlmacenamientoInterface extends Remote {
    public String guardar(String clave, String valor) throws RemoteException;
    public String obtener(String clave) throws RemoteException ;
    public String eliminar(String clave) throws RemoteException ;
}
