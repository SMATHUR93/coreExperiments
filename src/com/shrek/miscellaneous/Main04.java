package com.shrek.miscellaneous;

import java.text.DateFormat;
import java.util.Date;

public class Main04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		DateFormat df=DateFormat.getInstance();
		Date date=new Date();
		String currDate=df.format(date);
		System.out.println(currDate);
	}

}
