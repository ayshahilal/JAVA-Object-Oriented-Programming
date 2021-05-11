package java_proje;

public class RegularVehicle implements Vehicle{
	
	private String plate;

	public RegularVehicle(String plate) {
		super();
		this.plate=plate;

		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPlate() {
		// TODO Auto-generated method stub
		return plate;
	}

	@Override
	public Subscription getSubscription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSpecial() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
