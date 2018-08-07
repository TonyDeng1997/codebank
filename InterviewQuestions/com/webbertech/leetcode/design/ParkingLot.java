package com.webbertech.leetcode.design;

import java.util.ArrayList;
import java.util.Arrays;

enum VehicleSize {
	MOTORCYLE, //motor bike
	REGULAR, //compack, full size sedan and van
	LARGE  //big van and bus
}


abstract class Vehicle {
    VehicleSize size = null;
    String LicensePlate = null;

    // used for bus that takes 3 lots for example
    int numberOfParkingSpots = 0;    
    ArrayList<ParkingSpot> lotsOccupied = null;

    
    public void parkCar(ParkingSpot[] spots) {} 
	
	public void freeLots() {}
}


class Car extends Vehicle {
	
	public Car(String LicensePlate, VehicleSize size,  int numberOfParkingSpots) {
		this.LicensePlate = LicensePlate;
		this.size = VehicleSize.REGULAR;
		this.numberOfParkingSpots = 1;
	}
	
	public void parkCar(ParkingSpot[] spots) {
		this.lotsOccupied = new ArrayList<>();
		lotsOccupied.addAll(Arrays.asList(spots));
	}
	
	public void freeLots() {
		lotsOccupied.removeAll(lotsOccupied);
	}
}


class Bus extends Vehicle {
	public Bus(String LicensePlate, VehicleSize size,  int numberOfParkingSpots) {
		this.LicensePlate = LicensePlate;
		this.size = VehicleSize.LARGE;
		this.numberOfParkingSpots = 1;
	}
}

class Motorcycle extends Vehicle {
	public Motorcycle(String LicensePlate, VehicleSize size,  int numberOfParkingSpots) {
		this.LicensePlate = LicensePlate;
		this.size = VehicleSize.MOTORCYLE;
		this.numberOfParkingSpots = 1;
	}
	
}


class Level {
	int level_no; //which floor
	ParkingSpot[] spots;
	final int ROWS= 4;
	final int NUM_IN_ROW = 10;
	int availableLots;
	
	public Level(int level_no, int numberOfLots) {}
	
	public int getAvailableLots() { return availableLots;}
	
	public boolean parkVehicle(Vehicle v) { return true;}  //decrease avaiableLots, park a regular or motorcycle
	public boolean parkStartingAtSpot(int num, Vehicle v) {return true;} //use this instead of above when it is a bus
	public int findAvailableLot(Vehicle v) {return 0;} //will be used for above method if this is a bus
	public void freeLots() {availableLots++;}
}


class LotProperty {
	int depth;
	int width;
	int isleWidth;
	LotAngle angle;
	
	//constructor
	
	//setter/getter
}

//
enum ParkingType {
	REGULAR, HANDICAPED
}

enum LotAngle {
	HORIZONAL, VERTICAL, ANGLED//45-60 degrees
}


// each slot class
class ParkingSpot {
  private Vehicle vehicle;
  private LotProperty property;
  private Level level;
  private int row;
  private int spotNumber;
  private ParkingType parkingType;  
  
  //constructor
  
  boolean isAvailable() {
	  return vehicle == null;
  }
  
  boolean canFitVehicle(Vehicle v) {return true;} //what pass in a bus
  
  public boolean park(Vehicle v) { return true;}
  
  public void removeVehicle() {}
  
  //getter methods
}


public class ParkingLot {
	private Level[] level;
	final int MAX_LEVEL = 5;
	
	public boolean parkVehicle() {
		 return true;
    }
} 