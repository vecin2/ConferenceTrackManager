package main.core;

import static main.core.LengthConstraint.lengthBetween;
import static main.core.LengthConstraint.maxLengthOf;

import java.util.ArrayList;
import java.util.Iterator;

public class Track {
	Session morningSession;
	Session afternoonSession;

	public Track(Session morningSession, Session afternoonSession) {
		this.morningSession = morningSession;
		this.afternoonSession = afternoonSession;
	}

	public boolean schedule(ArrayList<Talk> talks) {
		if (talks.isEmpty()) {
			return true;
		}
		ArrayList<ArrayList<Talk>> talksPermutations = new PermutationsCalculator<Talk>()
				.calculate(talks);
		for (ArrayList<Talk> currentOption : talksPermutations) {
			if (isSatisfied(currentOption))
				return true;
		}

		return false;
	}

	private Boolean isSatisfied(ArrayList<Talk> currentOption) {
		if (addAll(currentOption)) {
			return true;
		}
		clearAll();
		return false;
	}

	private void clearAll() {
		morningSession.clear();
		afternoonSession.clear();
	}

	private boolean addAll(ArrayList<Talk> talks) {
		Iterator<Talk> iterator = talks.iterator();
		while (iterator.hasNext())
			if (!add(iterator.next())) {
				return false;
			}
		return true;
	}

	private boolean add(Talk talk) {
		return morningSession.schedule(talk) || afternoonSession.schedule(talk);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((afternoonSession == null) ? 0 : afternoonSession.hashCode());
		result = prime * result
				+ ((morningSession == null) ? 0 : morningSession.hashCode());
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
		Track other = (Track) obj;
		if (afternoonSession == null) {
			if (other.afternoonSession != null)
				return false;
		} else if (!afternoonSession.equals(other.afternoonSession))
			return false;
		if (morningSession == null) {
			if (other.morningSession != null)
				return false;
		} else if (!morningSession.equals(other.morningSession))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Track [morningSession=" + morningSession
				+ ", afternoonSession=" + afternoonSession + "]";
	}

	public ArrayList<Talk> getTalks() {
		ArrayList<Talk> result = new ArrayList<Talk>();
		result.addAll(morningSession.getTalks());
		result.addAll(afternoonSession.getTalks());
		return result;
	}

	public static Track createDayTrack() {
		return new Track(new Session(9, maxLengthOf(180)), new Session(13,
				lengthBetween(180, 240)));
	}

}
