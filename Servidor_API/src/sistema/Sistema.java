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
import java.rmi.registry.LocateRegistry;
import modelos.Almacenamiento;

/**
 *
 * @author kachu
 */
public class Sistema {

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        /*
            ¿Que argumentos recibo?
            Recibo ip y puerto del nodo
        
            Tengo que decidir si crear y volver a acomodar el sistema de almacenamiento
            o nada
        
            LocateRegistry.getRegistry(String host, int port)
        
            
         */

        if (args.length == 2) {
            
            String ip = args[0];
            int puerto = 0;
            System.setProperty("java.rmi.server.hostname",ip);
            try {
                puerto = Integer.parseInt(args[1]);
            } catch (Exception e) {
                System.out.println("Error en el puerto");
                System.exit(0);
            }            
            //Indicamos como se accede a nuestra clase
            try {
                //Registramos el puerto
//                while (true){
//                    AlmacenamientoInterface servidorPrincipal = (AlmacenamientoInterface) 
//                    Naming.lookup("//172.19.0.2:15000"+"");
//                     //Indicamos como se accede a nuestra clase
//                    Naming.rebind("//"+ip+":"+puerto+"", servidorPrincipal);
//                }
                
            } catch (Exception e) {
                System.out.println("3 - instancia principal caída.");
                System.exit(0);
            }
            
            
        } else {
            
            System.out.println("Error en los argumentos, debe indicar un ip y un puerto");
            System.exit(0);
        }

    }
}
