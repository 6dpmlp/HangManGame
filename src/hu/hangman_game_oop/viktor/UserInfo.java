package hu.hangman_game_oop.viktor;

class UserInfo {
	
	void greet() {
		System.out.printf("%s%n", "Welcome to the Hangman Game!");
	}
	
	void adviseRules() {
		System.out.printf("%nYou have to guess a word in each game.\r\n"
				+ "The word to guess can be at most a seven-letter long English word, which can be a noun, an adjective or a verb.\r\n"
				+ "You can only guess a letter at a time! You have to find all the letters to succeed!\r\n"
				+ "To do so, you have at most %d guesses. If you guess a letter correctly, the program will reveal all of them in the word\r\n"
				+ "and also it will keep track of the wrong guesses. When you take a guess\r\n"
				+ "lowercase and uppercase letters are equal.", Constants.getMaxNumWrongTips());
	}
	
	void farewell() {
		System.out.printf("%nGoodbye!%n");
	}
}
