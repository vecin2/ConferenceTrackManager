package main.core;

import java.util.ArrayList;

public class Session {

	private Constraint constraint;
	private ArrayList<Talk> talks = new ArrayList<Talk>();
	private ConferenceCalendar startTime;

	public Session(int startHourOfDay, Constraint constraint) {
		startTime = ConferenceCalendar.makeTime(startHourOfDay, 0);
		this.constraint = constraint;
	}

	public Session withConstraint(Constraint constraint) {
		this.constraint = constraint;
		return this;
	}

	public boolean schedule(Talk talk) {
		if (!constraint.canSatisfy(talk.getLength() + currentLengthFilled()))
			return false;
		else {
			talk.setStartTime(getEndTime());
			return talks.add(talk);

		}
	}

	private ConferenceCalendar getEndTime() {
		if (talks.isEmpty())
			return startTime;

		return getLastTalk().getEndTime();
	}

	private Talk getLastTalk() {
		return talks.get(talks.size() - 1);
	}

	private int currentLengthFilled() {
		int result = 0;

		for (Talk talk : talks) {
			result += talk.getLength();
		}
		return result;
	}

	public ArrayList<Talk> getTalks() {
		return talks;
	}

	public Boolean contains(Talk talk) {
		return talks.contains(talk);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((constraint == null) ? 0 : constraint.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((talks == null) ? 0 : talks.hashCode());
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
		Session other = (Session) obj;
		if (constraint == null) {
			if (other.constraint != null)
				return false;
		} else if (!constraint.equals(other.constraint))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (talks == null) {
			if (other.talks != null)
				return false;
		} else if (!talks.equals(other.talks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Session [constraint=" + constraint + ", talks=" + talks
				+ ", startTime=" + startTime + "]";
	}

	public void clear() {
		talks.clear();
	}

}
