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
            si no recibo argumentos 
                //10.0.0.20:15000/

            si recibo argumentos
                //10.0.0.20:+args[x]+/
         */

        if (args.length == 0) {
            //creamos la interfaz
            Almacenamiento almacenamiento = new Almacenamiento();

            //Registramos el puerto
            LocateRegistry.createRegistry(15000);
            //Indicamos como se accede a nuestra clase
            Naming.rebind("//localhost:15000/almacenamiento", almacenamiento);
        } else if (args.length == 2) {

            String ip = args[0];
            int puerto = 0;

            try {
                puerto = Integer.parseInt(args[1]);
            } catch (Exception e) {
                System.out.println("Error en el puerto");
                System.exit(0);
            }            
            //Indicamos como se accede a nuestra clase
            try {
                //Registramos el puerto
                LocateRegistry.createRegistry(puerto);
                
                while (true){
                    AlmacenamientoInterface servidorPrincipal = (AlmacenamientoInterface) 
                    Naming.lookup("//"+ip+":15000"+"/almacenamiento");
                     //Indicamos como se accede a nuestra clase
                    Naming.rebind("//localhost:"+puerto+"/almacenamiento", servidorPrincipal);
                }
                
            } catch (Exception e) {
                System.out.println("Error el servicio no esta disponible");
                System.exit(0);
            }
            
            
        } else {
            
            System.out.println("Error en los parametros");
            System.exit(0);
        }

    }
}
