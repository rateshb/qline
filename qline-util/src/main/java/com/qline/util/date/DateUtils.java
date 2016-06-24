package com.qline.util.date;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static boolean isCurrentDateBetween(Date periodStartDate, Date periodEndDate) {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		return isDateBetweenDates(periodStartDate, periodEndDate, today);
	}
	
	public static boolean isDateOneBeforeOrSameAsDateTwo(Date dt1 , Date dt2) {
		if ( removeTime(dt1).before(removeTime(dt2)) || removeTime(dt1).equals(removeTime(dt2))) {
			return true;
		}
		return false;
	}	
	
	public static boolean isDateBetweenDates(Date periodStartDate, Date periodEndDate, Date effectiveDate) {
		if (null == periodStartDate || null == periodEndDate || null == effectiveDate) {
			return false;
		}
		if ((isDateOneBeforeOrSameAsDateTwo(periodStartDate, effectiveDate))
				&& (isDateOneBeforeOrSameAsDateTwo(effectiveDate, periodEndDate))) {
			return true;
		}

		return false;
	}
	
	public static Date removeTime(Date date) {    
	    Calendar cal = Calendar.getInstance();  
	    cal.setTime(date);  
	    cal.set(Calendar.HOUR_OF_DAY, 0);  
	    cal.set(Calendar.MINUTE, 0);  
	    cal.set(Calendar.SECOND, 0);  
	    cal.set(Calendar.MILLISECOND, 0);  
	    return cal.getTime(); 
	}
	
}
