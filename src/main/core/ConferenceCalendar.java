package main.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConferenceCalendar {
	Calendar calendar;

	public ConferenceCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public static ConferenceCalendar makeTime(int startHourOfDay, int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.HOUR_OF_DAY, startHourOfDay);
		calendar.set(Calendar.MINUTE, minutes);
		return new ConferenceCalendar(calendar);
	}

	public static Date add(Date startTime, int hoursToAdd, int minutesToAdd) {
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((calendar == null) ? 0 : calendar.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConferenceCalendar other = (ConferenceCalendar) obj;
		if (calendar == null) {
			if (other.calendar != null)
				return false;
		} else if (!calendar.equals(other.calendar))
			return false;
		return true;
	}
	@Override
	public String toString(){
		return getFormartedTime();
	}



	public String getFormartedTime() {
		SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat
				.getTimeInstance();
		dateFormat.applyPattern("hh:mma");
		return dateFormat.format(calendar.getTime());
	}

	public Calendar getCalendar() {
		return this.calendar;
	}

	public ConferenceCalendar add(int field, int amount) {
		Calendar computedTime = (Calendar) getCalendar().clone();
		computedTime.add(field, amount);
		return new ConferenceCalendar(computedTime);
	}

}
