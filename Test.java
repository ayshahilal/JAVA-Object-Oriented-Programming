package java_proje;


public class Test{
	
public static void main(String[] args) {
		
		AutoPark park = new AutoPark(5,50);
		
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

		
		park.addVehicle(s1);
		park.addVehicle(s2);
		park.addVehicle(s3);
		
		
		System.out.println("---------------------------------------------------------");
		
		Time enter = new Time(16, 5);
		Date enterDate = new Date(17, 5, 2019);
		Time exit = new Time(17, 10);
		Time exit2 = new Time(19, 10);
		Time exit3 = new Time(21, 10);

		park.vehicleEnters(s1.getPlate(), enter,enterDate, false);
		park.vehicleEnters(s2.getPlate(), enter,enterDate, false);
		park.vehicleEnters(s3.getPlate(), enter,enterDate, false); 
		
		System.out.println("---------------------------------------------------------");
		
		park.vehicleEnters(r1.getPlate(), enter,enterDate, false);
		park.vehicleEnters(r2.getPlate(), enter,enterDate, false);
		park.vehicleEnters(r3.getPlate(), enter,enterDate, false);
		
		System.out.println("---------------------------------------------------------");
		
		park.vehicleEnters(o1.getPlate(), enter,enterDate, true);
		park.vehicleEnters(o2.getPlate(), enter,enterDate, true);
		park.vehicleEnters(o3.getPlate(), enter,enterDate, true);
		
		System.out.println("---------------------------------------------------------");

		park.isParked(s2.getPlate()); // 02 SV 02 otoparkta mi diye bakiyoruz.
		
		System.out.println("---------------------------------------------------------");
		// 3 araba turu icin cýkýslar:
		park.vehicleExits(s1.getPlate(), exit); // Subscripted olduðu için para ödemez
		park.vehicleExits(o1.getPlate(), exit); // Offical olduðu icin para odemez
		park.vehicleExits(r1.getPlate(), exit2); // regular oldugu icin para oder, odedigi para hesaplanýp sunulur
		
		System.out.println("---------------------------------------------------------");
		
		park.vehicleExits(s2.getPlate(), exit2);
		park.vehicleExits(r2.getPlate(), exit3);
		
		System.out.println("---------------------------------------------------------");
		
		park.vehicleExits(s3.getPlate(), exit);
		park.vehicleExits(r3.getPlate(), exit);
		
		System.out.println("---------------------------------------------------------");
		
		System.out.println(park.toString()); 
	
		
		
		
	}


}
