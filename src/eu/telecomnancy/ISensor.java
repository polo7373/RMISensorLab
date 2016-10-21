/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

/**
 *
 * @author charoy
 */

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ISensor extends Remote {
    public double getValue() throws SensorNotActivated,RemoteException;
    public void onOff() throws RemoteException;
    public boolean getStatus()throws RemoteException;
    public void addSensorListener(SensorListener listener) throws java.rmi.RemoteException;
    public void removeSensorListener(SensorListener listener) throws java.rmi.RemoteException;

}
