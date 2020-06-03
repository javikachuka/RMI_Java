/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import interfaces.AlmacenamientoInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author kachu
 */
public class Sistema {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
     
        //Estamos accediendo remotamente a almacenamiento que esta del lado del servidor
        AlmacenamientoInterface servidor = (AlmacenamientoInterface)
        Naming.lookup("//localhost:15000/almacenamiento");
        
        System.out.println(servidor.guardar("Javi", "Trabado"));
        //System.out.println(servidor.guardar("javi", "Trabadito"));
        
        System.out.println(servidor.obtener("Javi"));
        //System.out.println(servidor.obtener("javi"));
        
    }
}
