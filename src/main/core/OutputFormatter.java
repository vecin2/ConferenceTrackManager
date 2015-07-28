package main.core;


public class OutputFormatter {

	public String formatTalk(Talk talk) {
		
		return talk.getFormartedStartTime() + " " + talk.getTitle()
				+ " " + talk.getLength() + "min";
	}

	public String formatSession(Session session) {
		String result ="";
		for(Talk talk: session.getTalks()){
			result += formatTalk(talk) +"\n";
		}
		if(!result.isEmpty())
			result = result.substring(0, result.length()-1);
		return result;
	}

}
