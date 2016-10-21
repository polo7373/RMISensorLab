/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

/**
 *
 * @author charoy
 */
<<<<<<< HEAD

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ISensor extends Remote {
    public double getValue() throws SensorNotActivated,RemoteException;
    public void onOff() throws RemoteException;
    public boolean getStatus()throws RemoteException;
=======
public interface ISensor {
    public double getValue() throws SensorNotActivated;
    public void onOff();
    public boolean getStatus();
>>>>>>> cc05a52218b826b755434f708099f184f9fd5393
}
