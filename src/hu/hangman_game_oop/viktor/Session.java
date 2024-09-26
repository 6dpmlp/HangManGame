package hu.hangman_game_oop.viktor;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Session {

	private final Scanner scn;
	private final Random random = new Random();
	private final String wordToFind;
	private String hiddenResult;
	private String mismatches;

	public Session(Scanner scn) {
		this.scn = scn;
		wordToFind = chooseWord();
		hiddenResult = createHiddenResult(wordToFind);
		mismatches = "";
	}

	void play() throws QuitException {
		String actualLetter = null;
		for (printLine(); isSessionEnd(); printLine()) {
			actualLetter = askLetter();
			updateWords(actualLetter);
		}
		evaluate();
	}

	private boolean isSessionEnd() {
		return !(mismatches.length() >= Constants.getMaxNumWrongTips()) && !hiddenResult.replaceAll(" ", "").equals(wordToFind);
	}

	private String chooseWord() {
		return Constants.getWords()[random.nextInt(Constants.getWords().length)].toUpperCase();
	}

	private String askLetter() throws QuitException {
		String letter = Constants.getInitialString();
		while (!Constants.getAlphabet().contains(letter) || 1 != letter.length()) {
			System.out.print("Guess a letter: ");
			letter = scn.nextLine().toUpperCase().strip();
		}
		if (letter.equals(Constants.getCharToQuit())) {
			throw new QuitException();
		}
		return letter;
	}

	private String createHiddenResult(String word) {
		return "_ ".repeat(word.length() - 1) + "_";
	}

	private void updateWords(String letter) throws QuitException {
		if (0 > wordToFind.indexOf(letter) && 0 > mismatches.indexOf(letter)) {
			mismatches += letter;
			rearrangeMismatches();
			return;
		}
		String[] hiddenResultArr = hiddenResult.split("");
		String[] wordToFindArr = wordToFind.split("");
		for (int i = 0; i < wordToFind.length(); ++i) {
			if (letter.equals(wordToFindArr[i])) {
				hiddenResultArr[i * 2] = wordToFindArr[i];
			}
		}
		hiddenResult = String.join("", hiddenResultArr);
	}

	private void rearrangeMismatches() {
		String[] mismatchesArr = mismatches.split("");
		Arrays.sort(mismatchesArr, Constants.getCollator());
		mismatches = String.join("", mismatchesArr);
	}

	private void printLine() {
		String interimResult = hiddenResult;
		String[] mismatchArr = mismatches.split("");
		String interimMismatch = Arrays.toString(mismatchArr);
		if (!mismatches.isEmpty()) {
			interimResult = interimResult + "      Wrong guesses: ";
			if (1 == interimMismatch.length()) {
				interimResult = interimResult + interimMismatch;
			} else {
				interimResult = interimResult + interimMismatch.substring(1, interimMismatch.length() - 1);
			}
		}
		System.out.printf("%n%s%n", interimResult);
	}

	private void evaluate() {
		System.out.printf(String.format(
				"%n" + (mismatches.length() >= Constants.getMaxNumWrongTips() ? Constants.getHeadsUp() : Constants.getCongrats()), wordToFind));
	}
}
