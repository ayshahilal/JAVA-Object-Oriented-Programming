package java_proje;

import java.util.Calendar;
//import java.util.Scanner;

public class Date {
	
	private int day,month,year;
	//private static Scanner giris;
	
	public Date(int day, int month, int year) {
		
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}


	public int getMonth() {
		return month;
	}


	public int getYear() {
		return year;
	}


	public boolean isAfterThan(Date other) {
		if(year>other.year)
			return true;
		if(year == other.year && month > other.month)
			return true;
		if(year == other.year && month == other.month && day > other.day)
			return true;
		
		return false;
	}
	
	public boolean isBeforeThan(Date other) {
		if(year<other.year)
			return true;
		if(year == other.year && month < other.month)
			return true;
		if(year == other.year && month == other.month && day < other.day)
			return true;
		
		return false;
	}
	
	public boolean isEqualsThan(Date other) {
		if(day==other.day && month == other.month && year == other.day)
			return true;
		return false;
	}
	
	public static Date getToday() {
//		
//		giris = new Scanner(System.in);
//		System.out.println("Tarihi giriniz\n");
//		
//		
//		Date today = new Date( giris.nextInt(),giris.nextInt(),giris.nextInt());
		
		Calendar now = Calendar.getInstance();
		Date today = new Date( now.get(Calendar.DAY_OF_MONTH), (now.get(Calendar.MONTH)+1) , now.get(Calendar.YEAR));
		
		return today;
		
	}

}
