/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import modelos.Almacenamiento;

/**
 *
 * @author kachu
 */
public class Sistema {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        //creamos la interfaz
        Almacenamiento almacenamiento = new Almacenamiento();
        
        //Registramos el puerto
        LocateRegistry.createRegistry(15000);
        //Indicamos como se accede a nuestra clase
        Naming.rebind("//localhost:15000/almacenamiento", almacenamiento);
        
        
        
    }
}
