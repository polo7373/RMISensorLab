/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
/**
 *
 * @author charoy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	System.out.println("Test");
    	
    	try {
    		Registry r = LocateRegistry.getRegistry(7373);
    		ISensor s = (ISensor) r.lookup("sensor");
    		Client c=new Client(s);
    		s.addSensorListener(c);
    		
            c.menu();
    	} catch (RemoteException e){
    		e.printStackTrace();
    	} catch (NotBoundException e){
    		e.printStackTrace();
    	}
    }
}
