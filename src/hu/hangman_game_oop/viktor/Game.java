package hu.hangman_game_oop.viktor;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		new Game().run();
	}

	private void run() {
		if (null != Constants.getWords()) {
			var userInfo = new UserInfo();
			userInfo.greet();
			userInfo.adviseRules();
			doRun();
			userInfo.farewell();
		} else {
			return;
		}
	}

	private void doRun() {
		try (Scanner scn = new Scanner(System.in)) {
			for (boolean first = true; gameToStart(scn, first); first = false) {
				try {
					var session = new Session(scn);
					session.play();
				} catch (QuitException qe) {
					return;
				}
			}
		}
	}

	private boolean gameToStart(Scanner scn, boolean first) {
		System.out.printf("%n%nCan the %s round start? ", first ? "first" : "next");
		return !scn.nextLine().toLowerCase().trim().startsWith("n");
	}
}
