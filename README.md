# HangmanGameOOP

## Overview
HangmanGameOOP is an object-oriented implementation of the classic Hangman game, with a strong emphasis on adhering to SOLID principles. The game selects a word randomly from a file.

## Features
- **Random Word Selection**: Words are randomly selected from a predefined file.
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
2. Guess the word by entering one letter at a time.
3. The game will display the current state of the word and the remaining tries after each guess.

## Code Structure
- **Main.java**: The entry point of the application.
- **Game.java**: Handles the game logic.
- **QuitException.java**: The class helps the user to quit during the game.
- **Session.java**: Responsible for arranging one session.
- **UserInfo.java**: Informs the user about the rules of the game.
