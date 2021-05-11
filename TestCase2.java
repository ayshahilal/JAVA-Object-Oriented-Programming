package java_proje;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCase2 {
	
	static final AutoPark park = new AutoPark(6.5,30);
	
	RegularVehicle r1 = new RegularVehicle("01 AHD 01");
	RegularVehicle r2 = new RegularVehicle("02 AHD 02");
	RegularVehicle r3 = new RegularVehicle("03 AHD 03");
	
	OfficialVehicle o1 = new OfficialVehicle("01 SS 01");
	OfficialVehicle o2 = new OfficialVehicle("02 SS 02");
	OfficialVehicle o3 = new OfficialVehicle("03 SS 03");
	
	
     Date begin1 = new Date(12, 4, 2016);
     Date end1 = new Date(24, 5, 2020);
     
     Date begin2 = new Date(12, 4, 2012);
     Date end2 = new Date(6, 5, 2018);
     
     Date begin3 = new Date(12, 4, 2010);
     Date end3 = new Date(18, 5, 2015);
      
	Subscription sub1 = new Subscription(begin1,end1,"01 AD 01");
	SubscribedVehicle s1 = new SubscribedVehicle("01 AD 01", sub1);
	Subscription sub2 = new Subscription(begin2,end2,"02 AD 02");
	SubscribedVehicle s2 = new SubscribedVehicle("02 AD 02", sub2);
	Subscription sub3 = new Subscription(begin3,end3,"03 AD 03");
	SubscribedVehicle s3 = new SubscribedVehicle("03 AD 03", sub3);

	
	@Before
	public void setUp() {


		park.addVehicle(s1);
		park.addVehicle(s2);
		park.addVehicle(s3);
		try {
			park.vehicleEnters(o1.getPlate(), new Time(25,20), Date.getToday(), true);
			park.vehicleEnters(o2.getPlate(), new Time(31,30), Date.getToday(), true);
			park.vehicleEnters(o3.getPlate(), new Time(14,10), Date.getToday(), true);
			park.vehicleEnters(s1.getPlate(), new Time(14,20), Date.getToday(), false);
			park.vehicleEnters(s2.getPlate(), new Time(15,20), Date.getToday(), false);
			park.vehicleEnters(s3.getPlate(), new Time(12,20), Date.getToday(), false); 
			park.vehicleEnters(r1.getPlate(), new Time(13,10), Date.getToday(), false);
			park.vehicleEnters(r2.getPlate(), new Time(32,10), Date.getToday(), false);
			park.vehicleEnters(r3.getPlate(), new Time(19,20), Date.getToday(), false);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			park.vehicleExits(r3.getPlate(), new Time(12, 10)); 
			park.vehicleExits(r2.getPlate(), new Time(19, 10)); // regular oldugu icin para oder, odedigi para hesaplanip sunulur		
		}
		catch(Exception e) { }
	}
	
	@Test
	public void testIsParked() {
		boolean output = park.isParked(s1.getPlate());
		assertEquals(true,output);
		
	}
	
	@Test
	public void testIsValid() {
		boolean output = sub2.isValid();
		assertEquals(false,output);
		
	}
	
	@Test
	public void testAddVehicle() {
		boolean output = park.addVehicle(s2);
		assertEquals(false,output);
		
	}
	
	@Test
	public void testSearchVehicle() {
		SubscribedVehicle vehicle = park.searchVehicle("01 SS 01"); // search a vehicle that does not exist
		assertEquals(null,vehicle);
		
	}
	
	@Test
	public void testVehicleEnters() {
		
		try {
			park.vehicleEnters(s2.getPlate(), new Time(17,30), Date.getToday() , false); //enter the vehicle that has already entered
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
