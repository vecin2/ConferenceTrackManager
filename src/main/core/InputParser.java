package main.core;

import java.util.ArrayList;

public class InputParser {

	public ArrayList<Talk> parseInput(String input) {
		String[] lines = input.split("\n");
		ArrayList<Talk> talks= new ArrayList<Talk>();
 		for(int i=0; i< lines.length; i++){
			talks.add(parseTalk(lines[i]));
		}
 		return talks;
	}

	private Talk parseTalk(String talk) {
		String[] words = talk.split(" ");
		return new Talk(parseTitle(words), parseDuration(words));
	}

	private String parseTitle(String[] words) {
		String result = makePhrase(words);
		return result;
	}

	private int parseDuration(String[] words) {
		if (words[words.length - 1].equals("lightning")) {
			return 5;
		} else {
			return Integer.parseInt(words[words.length - 1].split("min")[0]);
		}
	}

	private String makePhrase(String[] words) {
		String result = "";
		for (int i = 0; i < words.length - 1; i++) {
			result += words[i] + " ";
		}
		if (result.length() > 0) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

}
