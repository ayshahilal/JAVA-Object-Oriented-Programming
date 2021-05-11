package java_proje;

public class ParkRecord {
	
	Time enterTime,exitTime;
	Date enterDate;
	Vehicle vehicle;
	
	
	public ParkRecord(Time enterTime, Date enterDate, Vehicle vehicle) {
		
		this.enterDate = enterDate;
		this.enterTime = enterTime;
		this.exitTime = null;
		this.vehicle = vehicle;
	}
	
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	
	public Date getEnterDate() {
		return enterDate;
	}
	
	public void setEnterTime(Time enterTime) {
		this.enterTime = enterTime;
	}


	public void setExitTime(Time exitTime) {
		this.exitTime = exitTime;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public Time getEnterTime() {
		return enterTime;
	}


	public Time getExitTime() {
		return exitTime;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public int getParkingDuration() {
		return 0;
		
		
	}
	

}
