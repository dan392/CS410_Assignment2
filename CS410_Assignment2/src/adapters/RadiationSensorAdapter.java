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

import sensor.RadiationSensor;






/*
 * This class is an adapter for the Radiation Sensor class to allow communication between the Sensor Application, to adapt
 * the methods from the Radiation Sensor, so that it fits the needs of the Sensor Application.
 */
public class RadiationSensorAdapter implements SensorApplicationInterface{
	RadiationSensor adaptee; //creates an adaptee object to allow communication to the Radiation Sensor class
	private double value; //value of the Radiation Sensor reading
 
	/*
	 * Constructor that takes in a RadiationSensor object
	 */
	public RadiationSensorAdapter(RadiationSensor rs) {
		this.adaptee = rs; // sets the adaptee to the rs object
		this.value = rs.getRadiationValue(); // set's the value of the rs reading to the RadiationSensorAdapter reading
			
	}
	/*
	 * This method returns the adaptee's sensor name
	 */
	@Override
	public String getSensorName() {
		return adaptee.getName();
	}

	/*
	 * This method generates and returns the Color object for the gauge based on the
	 * adaptee's getReport result
	 */
	@Override
	public Color getColorCode() {
		//returns color of the gauge
		if(adaptee.getStatusInfo()== "OK")
			return Color.green;
		else if(adaptee.getStatusInfo() == "CRITICAL")
			return Color.yellow;
		else {
		return Color.red;
		}
	}
	/*
	 * This method generates and returns the length needed for the gauge based on
	 * the adaptee's getReport result
	 */
	@Override
	public int getLength() {
		//returns size in pixels of the gauge
		if(adaptee.getStatusInfo() == "OK") 
			return 20;
		else if(adaptee.getStatusInfo() == "CRITICAL")
			return 75;
		return 200;
	
	}

	/*
	 * This method returns the getReport based on the adaptee's value and it's
	 * reading value;
	 */
	@Override
	public String getMessage() {
		return adaptee.getStatusInfo() + " --> " + value; //message returned
	}
}
