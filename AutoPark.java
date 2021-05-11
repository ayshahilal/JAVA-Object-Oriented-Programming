package java_proje;

public class AutoPark {

	private SubscribedVehicle[] subscribedVehicles;
	private ParkRecord[] parkRecords ;
	private double hourlyFee,incomeDaily;
	private int capacity,PRcapacity,countSV, countPR, carCount;
	
	public AutoPark(double hourlyFee,int capacity) {
		
		this.hourlyFee = hourlyFee;
		this.capacity=capacity;
		this.PRcapacity=capacity;
		this.countSV=0;
		this.countPR=0;
		this.carCount=0;
		subscribedVehicles=new SubscribedVehicle[capacity];
		parkRecords=new ParkRecord[capacity];
		
	} 

	public double getHourlyFee() {
		
		return hourlyFee;
	}


	public double getIncomeDaily() {
		
		return incomeDaily;
	}
	
	public void setIncomeDaily(double incomeDaily) {
		this.incomeDaily = incomeDaily;
	}


	public void setParkRecords(ParkRecord[] parkRecords) {
		this.parkRecords = parkRecords;
	}


	public void setHourlyFee(double hourlyFee) {
		this.hourlyFee = hourlyFee;
	}

	public void setPRcapacity(int pRcapacity) {
		PRcapacity = pRcapacity;
	}

	public void setCountSV(int countSV) {
		this.countSV = countSV;
	}

	public void setCountPR(int countPR) {
		this.countPR = countPR;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public SubscribedVehicle searchVehicle(String plate) {
	
		for( int i = 0; i < countSV; i++ )
			if(subscribedVehicles[i].getPlate().compareTo(plate) == 0)
				return subscribedVehicles[i];
		return null;
	}
	
	public boolean isParked(String plate) {
		for( int i = 0; i < countPR; i++ )
			if( (parkRecords[i].getVehicle().getPlate().compareTo(plate) == 0) && (parkRecords[i].getExitTime()==null) )
				{
				//System.out.println(plate+" is Parked\n");
				return true;
				}
			
		return false;
		
	}
	
	public void enlargeVehicleArray(int newCapacity) {	//ParkRecord[] simdiye kadar giren cikan tum arabalarin bilgilerini kaydettigi icin, kapasite doldugunda 2 katina cikarir
		
		if( newCapacity <= PRcapacity )
            return;
		
		ParkRecord[] geciciDizi = new ParkRecord[ newCapacity ];
		for( int i = 0; i < countPR; i++ )
            geciciDizi[i] = parkRecords[i];
		
		parkRecords = geciciDizi;
		PRcapacity = newCapacity;
		System.out.println("Vehicle array enlarged\n");
		
	}
	
	public boolean addVehicle(SubscribedVehicle x) {
		
		if( countSV == capacity  || isParked( x.getPlate())) 			
			return false;
		
		subscribedVehicles[countSV] = x;
		System.out.println("Subscribed Vehicles : \n");
		for(int i=0; i<=countSV ; i++)
			System.out.println( " "+subscribedVehicles[i].getPlate()+ " \n");
		countSV++;
		return true;
	
	}
	
	public boolean vehicleEnters(String plate, Time enter,Date enterDate, boolean isOfficial ) {
		
		if( isParked(plate) || carCount == capacity )
			return false;
		if( countPR == PRcapacity )
			enlargeVehicleArray(2*PRcapacity);
		for( int i = 0; i < countSV; i++ )
			if(subscribedVehicles[i].getPlate().compareTo(plate) == 0 ) {
				
		
				parkRecords[countPR] = new ParkRecord(enter, enterDate, searchVehicle(plate));
				countPR++;
				carCount++;
			
				System.out.println( "Vehicle entered: "+plate+"   "+enter+ "\n");
				return true;
				
			}
		if(isOfficial) {
			OfficialVehicle vehicle = new OfficialVehicle(plate);			
			parkRecords[countPR] = new ParkRecord( enter,enterDate, vehicle);
			
		}
		else {
			RegularVehicle vehicle = new RegularVehicle(plate);			
			parkRecords[countPR] = new ParkRecord( enter, enterDate, vehicle);
			
		}
		countPR++; 	//parkRecords dizisinde kac kayit oldugunu belirler
		carCount++; //otoparkta guncel olarak kac araba oldugunu tutar
		System.out.println( "Vehicle entered: "+plate+"   "+enter+ "\n");
		return true;

	}
		
	public boolean vehicleExits(String plate, Time exit) {
		
		if(!isParked(plate))
			return false;
		for( int i = 0; i < countPR; i++ )
			if((parkRecords[i].getVehicle().getPlate().compareTo(plate) == 0))
				if(parkRecords[i].getExitTime() == null) {
					
					parkRecords[i].setExitTime(exit);
					carCount--;
					if(parkRecords[i].getVehicle().isSpecial()) {
						System.out.println("this car is offical car, no need to pay\n");
						System.out.println( "Vehicle exits: "+ plate+"  "+exit+ "\n");
						return true;
					}
					
					Date date = Date.getToday();
					if( parkRecords[i].getEnterDate().isBeforeThan(date) )
						setIncomeDaily( 0.0 );
					
					Time time = new Time( parkRecords[i].getEnterTime().getHour() , parkRecords[i].getEnterTime().getMinute()  );
					setIncomeDaily( getIncomeDaily() + getHourlyFee()*time.getDifference(exit));	
				}	
				System.out.println( "Vehicle exits: "+ plate+"  "+exit+ "\n");
				return true;
	}


	@Override
	public String toString() {

		return "\nhourlyFee=" + hourlyFee + "\nincomeDaily=" + incomeDaily
				+ "\ncapacity=" + capacity + "\nPRcapacity=" + PRcapacity + "\ncountSV=" + countSV + "\ncountPR="
				+ countPR + "\ncarCount=" + carCount;
	}
}
