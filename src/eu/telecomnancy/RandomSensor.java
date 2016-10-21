/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.util.ArrayList;
import java.util.Random;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


/**
 *
 * @author charoy
 */
public class RandomSensor extends UnicastRemoteObject implements ISensor {

	private boolean status=false; //false = off - true = on
      double start = 50;
      	double end = 100;
      	
    private double tmp;
    private ArrayList<SensorListener> list = new ArrayList<>();
    
    protected RandomSensor() throws RemoteException {
    	super();
		tmp = 50.0;
	}
    
    @Override
    public double getValue() throws SensorNotActivated, RemoteException {
        if (status) {
         double random = new Random().nextDouble();
        return start + (random * (end - start));    
        } else throw new SensorNotActivated("random Sensor not activated");
    }

    @Override
    public void onOff() throws RemoteException {
        status=!status;
        notifyListeners();
    }

    @Override
    public boolean getStatus() throws RemoteException {
        return status;
    }
    
    public void addSensorListener(SensorListener listener) throws java.rmi.RemoteException {
    	System.out.println("adding listener -"+listener);
    	list.add(listener);
    }

    public void removeSensorListener(SensorListener listener) throws java.rmi.RemoteException {
    	System.out.println("removing listener -"+listener);
    	list.remove(listener);
    }
    
    private void notifyListeners() {
    	  for (int i = 0; i < list.size();i++){
    		  SensorListener listener = (SensorListener) list.get(i);
    	    try {
    	      listener.statusChanged();
    	    } 
    	    catch(RemoteException re){
    	        System.out.println("removing listener -"+listener);
    	        list.remove(listener); 
    	     }
    	    }
    }
    
    public static void main(String args[]) throws RemoteException {
	  System.out.println("Starting Server");
		ISensor s = new RandomSensor();
		try {
			Registry registry = null;
			
			registry = LocateRegistry.createRegistry(7373);
			registry.rebind("sensor", s);
		} catch (RemoteException e){
			e.printStackTrace();
		}
		System.out.println("Bound");
    }
}