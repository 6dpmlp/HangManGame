package hu.hangman_game_oop.viktor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.Locale;

class Constants {
	private static final String[] WORDS;
	private static final int MAX_NUM_WRONG_TIPS = 12;
	private static final String FILE_NAME = "Words.txt";
	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ*";
	private static final Collator COLLATOR = Collator.getInstance(Locale.UK);
	private static final String CHAR_TO_QUIT = "*";
	private static final String INITIAL_STRING = "dummy";
	private static final String CONGRATS = "You won, congrats!";
	private static final String HEADS_UP = "You have used up all your guesses!. The solution would have been \"%s\".";

	static {
		try {
			WORDS = (loadWords(Constants.getFileName()));
		} catch (IOException ioe) {
			throw new RuntimeException("A szószedet fájl nem található vagy nem olvasható.");
		}
	}

	private static String[] loadWords(String fileName) throws IOException {
		Path path = Path.of(fileName);
		return Files.readAllLines(path, StandardCharsets.UTF_8).toArray(String[]::new);
	}

	public static String getCongrats() {
		return CONGRATS;
	}

	public static String getHeadsUp() {
		return HEADS_UP;
	}

	public static int getMaxNumWrongTips() {
		return MAX_NUM_WRONG_TIPS;
	}

	public static String getFileName() {
		return FILE_NAME;
	}

	public static String getAlphabet() {
		return ALPHABET;
	}

	public static Collator getCollator() {
		return COLLATOR;
	}

	public static String getCharToQuit() {
		return CHAR_TO_QUIT;
	}

	public static String getInitialString() {
		return INITIAL_STRING;
	}

	public static String[] getWords() {
		return WORDS;
	}

}
