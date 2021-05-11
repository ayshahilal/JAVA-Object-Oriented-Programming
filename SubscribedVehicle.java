package java_proje;

public class SubscribedVehicle implements Vehicle{

	private String plate;
	private Subscription sub;

	public SubscribedVehicle(String plate , Subscription sub) {
		this.plate=plate;
		this.sub=sub;
		// TODO Auto-generated constructor stub
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public void setSub(Subscription sub) {
		this.sub = sub;
	}

	@Override
	public String getPlate() {
		// TODO Auto-generated method stub
		return plate;
	}

	@Override
	public Subscription getSubscription() {
		// TODO Auto-generated method stub
		return sub;
	}

	@Override
	public boolean isSpecial() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
