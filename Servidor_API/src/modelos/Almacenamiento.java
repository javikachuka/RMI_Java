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
public class Almacenamiento extends UnicastRemoteObject implements AlmacenamientoInterface {

    // private ArrayList<ArrayList> almacenamiento; 
    Hashtable<String, String> almacenamiento = new Hashtable<String, String>();

    public Almacenamiento() throws RemoteException {
    }

    public Almacenamiento(int port) throws RemoteException {
        super(port);
    }

    public Almacenamiento(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }
    
    public int validarClave(String clave){
        //Controlamos que sea alfanumerico y pueda contener _
        if (!(clave.matches("[a-zA-Z0-9_]"))){
            if ((clave.length() >= 1) && (clave.length() <= 50)){
                return 1;  
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
    
    public int validarValor(String valor){
        //Casteamos el string a un array de bytes
        byte[] b = valor.getBytes();
        //Controlamos que ese array pese 1.5MB
        if (b.length <= 1536){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    //0 para modificar, 1 para guardar uno nuevo y 2 error
    public int guardar(String clave, String valor) throws RemoteException {
        int retorno;
            if ((validarClave(clave) == 1) && (validarValor(valor) == 1)){
                try {
                if (almacenamiento.containsKey(clave)) {
                    almacenamiento.replace(clave, valor);
                    retorno = 0;
                } else {
                    almacenamiento.put(clave, valor);
                    retorno = 1;
                }
                } catch (Exception e) {
                    retorno = 2;
                }
            }else{
                retorno = 2;
            }
        return retorno;
    }

    @Override
    //retornamos el valor de la clave si existe else error(2)
    public String obtener(String clave) throws RemoteException {
        try {
            if(almacenamiento.containsKey(clave)){
                 return almacenamiento.get(clave);
            }
            else {
                return "2";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
       
    }

    @Override
    //si elimina retorna valor else retorna error(2)
    public String eliminar(String clave) throws RemoteException {
        String aux;
        try {
            if(almacenamiento.containsKey(clave)){
                 aux = almacenamiento.get(clave);
                 almacenamiento.remove(clave);
                 return "Esliminado " + aux;
            }
            else {
                return "2";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
