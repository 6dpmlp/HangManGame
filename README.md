# HangmanOOP

## Overview
HangmanOOP is an object-oriented implementation of the classic Hangman game, with a strong emphasis on adhering to SOLID principles. The game selects a word randomly from a file, and the user can set the number of tries they want to have to guess the word.

## Features
- **Random Word Selection**: Words are randomly selected from a predefined file.
- **Configurable Tries**: Users can set the number of attempts they want to guess the word.
- **SOLID Principles**: The code is designed following SOLID principles to ensure maintainability and scalability.

## Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/6dpmlp/HangManGame
    ```
2. Navigate to the project directory:
    ```sh
    cd HangmanOOP
    ```
3. Compile the project:
    ```sh
    javac -d bin src/*.java
    ```
4. Run the game:
    ```sh
    java -cp bin Main
    ```

## Usage
1. Start the game by running the `Main` class.
2. The game will prompt you to enter the number of tries you want.
3. Guess the word by entering one letter at a time.
4. The game will display the current state of the word and the remaining tries after each guess.

## Code Structure
- **Main.java**: The entry point of the application.
- **Game.java**: Handles the game logic.
- **QuitException.java**: The class helps the user to quit during the game.
- **Session.java**: Responsible for arrangement of one session.
- **UserInfo.java**: Informs the user about the rules of the game.
