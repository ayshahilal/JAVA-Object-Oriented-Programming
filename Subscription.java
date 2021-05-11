package java_proje;


public class Subscription {
	
	private Date begin,end;
	private SubscribedVehicle vehicle;
	
	public Subscription(Date begin, Date end, String plate) {
	
		this.setBegin(begin);
		this.end = end;
		setVehicle(new SubscribedVehicle(plate,this));
		
	}
	
	public boolean isValid() {
		Date date = Date.getToday();
		if( (this.end.isAfterThan(date)) || (this.end.isEqualsThan(date)) && (this.end.isBeforeThan(date))  )
			return true;
		return false;
		
	}

	
	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public SubscribedVehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(SubscribedVehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	

}
