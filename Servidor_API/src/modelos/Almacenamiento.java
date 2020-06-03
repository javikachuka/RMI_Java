/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.rmi.server.UnicastRemoteObject;
import interfaces.AlmacenamientoInterface;
import java.rmi.RemoteException;
/**
 *
 * @author kachu
 */
public class Almacenamiento extends UnicastRemoteObject implements AlmacenamientoInterface{

    @Override
    public int guardar(String clave, String valor) throws RemoteException {
        
    }

    @Override
    public String obtener(String clave) throws RemoteException {
        
    }

    @Override
    public String eliminar(String clave) throws RemoteException {
       
    }
    
}
