
//3. Third class - to get the Random number, system dates related details in the scripts.
package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		//Generate Random Number.
		Random random = new Random();
	    int r = random.nextInt(5000);
		return r;
	
	}
	
	//Capture the system date.
	public String getSystemDateyyyyMMdd()
	{
		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String date =  sim.format(dateObj);
		return date;
	}
	
	
	//Get required Date.
	public String getRequiredDateyyyyMMdd(int days)
	{
		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateObj);
		Calendar cal =  sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate  = sim.format(cal.getTime());
		return reqDate;
		
	}
	
//To capture Current date and time to attach it to the screenshot. added this code on 27-Sep-2024.
	public String getCurrentDateAndTimeForSS()
	{
		String date = new Date().toString().replace(" ", "_").replace(":", "_");
		return date;
	}

}
