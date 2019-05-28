/**
 * CS 410 - Assignment 2 
 * @author Daniyal Adzhiyev
 * @version 1.0 05/28/2019
 * 
 * This Application uses the Adapter Software Pattern to create adapter's for multiple predefined sensor classes.
 * Where the adapter classes implement the Sensor Application Interface, to 'adapt' the original sensor classes
 * so that all of the adapter classes have the same methods needed to display the information in the Sensor 
 * Application.
 *  
 */

package adapters;

import java.awt.Color;
/*
 * This is the interface for the Sensor Application to communicate with the Sensor Adapter's
 */
public interface SensorApplicationInterface {
	
	
	public String getSensorName(); //gets name of the sensor
	public Color getColorCode(); //gets color code based on the severity of the sensor reading
	public int getLength(); //gets the length of the Gauge based on severity of the sensor reading
	public String getMessage(); //prints out a message of the severity of the reading and it's value

}
