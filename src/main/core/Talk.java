package main.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Talk {

	private String title;
	private int duration;
	private ConferenceCalendar startTime;

	public Talk(String title, int duration) {
		this.title = title;
		this.duration = duration;
	}

	static public ArrayList<Talk> toList(Talk talk) {
		ArrayList<Talk>result = new ArrayList<Talk>();
		result.add(talk);
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duration;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Talk other = (Talk) obj;
		if (duration != other.duration)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Talk [title=" + title + ", duration=" + duration + "]";
	}

	public int getLength() {
		return duration;
	}

	public String getTitle() {
		return title;
	}

	public Talk setStartTime(ConferenceCalendar startTime) {
		this.startTime =startTime;
		return this;
	}

	public ConferenceCalendar getStartTime() {
		return this.startTime;
	}

	public String getFormartedStartTime() {
		return startTime.getFormartedTime();
	}

	public ConferenceCalendar getEndTime() {
		return getStartTime().add(Calendar.MINUTE, getLength());
	}

}
