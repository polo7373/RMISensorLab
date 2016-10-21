package eu.telecomnancy;

import java.rmi.RemoteException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static void main(String[] Args) throws RemoteException{
		System.out.println("Starting Server");
		ISensor s = new RandomSensor();
		try {
			ISensor stub = (ISensor) UnicastRemoteObject.exportObject(s,0);
			Registry registry = null;
			
			registry = LocateRegistry.createRegistry(7373);
			registry.rebind("sensor", stub);
		} catch (RemoteException e){
			e.printStackTrace();
		}
		System.out.println("Bound");
	}
}
