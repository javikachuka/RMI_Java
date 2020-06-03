/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.rmi.server.UnicastRemoteObject;
import interfaces.AlmacenamientoInterface;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author kachu
 */
public class Almacenamiento extends UnicastRemoteObject implements AlmacenamientoInterface{

   // private ArrayList<ArrayList> almacenamiento; 
    Hashtable<String, String> almacenamiento = new Hashtable<String, String>();

    public Almacenamiento(ArrayList<ArrayList> almacenamiento) throws RemoteException {
        this.almacenamiento = almacenamiento;
    }

    public Almacenamiento(ArrayList<ArrayList> almacenamiento, int port) throws RemoteException {
        super(port);
        this.almacenamiento = almacenamiento;
    }

    public Almacenamiento(ArrayList<ArrayList> almacenamiento, int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
        this.almacenamiento = almacenamiento;
    }

    public ArrayList<ArrayList> getAlmacenamiento() {
        return almacenamiento;
    }
    
    
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
