package java_proje;

public class Time {
	
	private int hour,minute;
	
	public Time(int hour, int minute) {
		super();
		this.hour = hour;
		this.minute = minute;
	}

	public int getDifference(Time other) {
		
		return other.hour*60+other.minute-(this.hour*60+this.minute);
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	
	
}
