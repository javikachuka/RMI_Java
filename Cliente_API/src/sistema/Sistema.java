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
        int puerto = 0;
        
        if (args.length == 2){
            try {
                String ip = args[0];
                puerto = Integer.parseInt(args[1]);
                //Estamos accediendo remotamente a almacenamiento que esta del lado del servidor
                AlmacenamientoInterface servidor = (AlmacenamientoInterface)
                Naming.lookup("//"+ip+":"+puerto+"");

                //Se crean dos elementos
                System.out.println(servidor.guardar("Clave1", "Valor1"));
                System.out.println(servidor.guardar("Clave2", "Valor2"));

                //Obtenemos los dos elementos
                System.out.println(servidor.obtener("Clave1"));
                System.out.println(servidor.obtener("Clave2"));

                //Intentamos guardar
                System.out.println(servidor.guardar("Clave1", "Nuevo valor1"));

                //Obtenemos los dos elementos nuevamente
                System.out.println(servidor.obtener("Clave1"));
                System.out.println(servidor.obtener("Clave2"));

                //Eliminamos el elemento con clave 2
                System.out.println(servidor.eliminar("Clave2"));


                //Obtenemos los dos elementos nuevamente
                System.out.println(servidor.obtener("Clave1"));
                System.out.println(servidor.obtener("Clave2"));

                System.out.println("Cliente finalizando...");
            
            } catch (Exception e) {
                System.out.println("4 - instancia principal caída ó error en el órden de los argumentos.");
                System.exit(0);
            }
        }else{
            System.out.println("Error en los argumentos");
            System.exit(0);
        }   

}
}
