package java_proje;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCase1 {
	
	static final AutoPark park = new AutoPark(5,50);
	
	RegularVehicle r1 = new RegularVehicle("01 RE 01");
	RegularVehicle r2 = new RegularVehicle("02 RE 02");
	RegularVehicle r3 = new RegularVehicle("03 RE 03");
	
	OfficialVehicle o1 = new OfficialVehicle("01 OV 01");
	OfficialVehicle o2 = new OfficialVehicle("02 OV 02");
	OfficialVehicle o3 = new OfficialVehicle("03 OV 03");
	
	
     Date begin1 = new Date(13, 4, 2015);
     Date end1 = new Date(17, 5, 2020);
     
     Date begin2 = new Date(12, 4, 2014);
     Date end2 = new Date(16, 5, 2017);
     
     Date begin3 = new Date(13, 4, 2013);
     Date end3 = new Date(15, 5, 2015);
      
	Subscription sub1 = new Subscription(begin1,end1,"01 SV 01");
	SubscribedVehicle s1 = new SubscribedVehicle("01 SV 01", sub1);
	Subscription sub2 = new Subscription(begin2,end2,"02 SV 02");
	SubscribedVehicle s2 = new SubscribedVehicle("02 SV 02", sub2);
	Subscription sub3 = new Subscription(begin3,end3,"03 SV 03");
	SubscribedVehicle s3 = new SubscribedVehicle("03 SV 03", sub3);

	
	@Before
	public void setUp() {
		
		park.addVehicle(s1);
		park.addVehicle(s2);
		park.addVehicle(s3);
		try {
			park.vehicleEnters(s1.getPlate(), new Time(17,30), Date.getToday(), false);
			park.vehicleEnters(s2.getPlate(), new Time(14,20), Date.getToday(), false);
			park.vehicleEnters(s3.getPlate(), new Time(12,50), Date.getToday(), false); 
			park.vehicleEnters(r1.getPlate(), new Time(1,10), Date.getToday(), false);
			park.vehicleEnters(r2.getPlate(), new Time(23,30), Date.getToday(), false);
			park.vehicleEnters(r3.getPlate(), new Time(17,20), Date.getToday(), false);
			park.vehicleEnters(o1.getPlate(), new Time(17,20), Date.getToday(), true);
			park.vehicleEnters(o2.getPlate(), new Time(9,30), Date.getToday(), true);
			park.vehicleEnters(o3.getPlate(), new Time(14,20), Date.getToday(), true);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			park.vehicleExits(r1.getPlate(), new Time(17, 10)); // regular oldugu icin para oder, odedigi para hesaplanýp sunulur		
		}
		catch(Exception e) { }
	}
	
	
	@Test
	public void testIsValid() {
		boolean output = sub1.isValid();
		assertEquals(true,output);
		
	}
	
	@Test
	public void testIsParked() {
		boolean output = park.isParked(s2.getPlate());
		assertEquals(true,output);
		
	}
	
	@Test
	public void testAddVehicle() {
		boolean output = park.addVehicle(s2);
		assertEquals(false,output);
		
	}

	@Test
	public void testSearchVehicle() {
		SubscribedVehicle vehicle = park.searchVehicle("03 RE 03"); // search a vehicle that does not exist
		assertEquals(null,vehicle);
		
	}
	
	@Test
	public void testVehicleEnters() {
		
		try {
			park.vehicleEnters(r1.getPlate(), new Time(17,30), Date.getToday() , false); //enter the vehicle that has already entered
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
