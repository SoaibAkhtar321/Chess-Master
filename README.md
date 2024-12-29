# README

#Chess Game

This is a chess game written in Java 8, using a JavaFX UI. The game allows you to play against a computer opponent 
and features game saving and loading using FEN and PGN notations.



## Table of Contents
1. [About the game](#about-the-game)  
	1.1 [Before you start the game](#before-you-start-the-game)  
	1.2 [The game](#the-game)  
		1.2.1 [The AI opponent](#the-ai-opponent)  
		1.2.2 [Chess notations](#chess-notations)  
		1.2.3 [Editing a game](#editing-a-game)  
		1.2.4. [Thoughts about this project](#thoughts-about-this-project)  
2. [Project structure](#project-structure)  
3. [How to get it](#how-to-get-it)
4.  [Technologies Used](#Technology-Used)
5. [Testing](Testing)



## About the game
### Before you start the game
![screenshot of settings screen](https://github.com/lpapailiou/chess/blob/master/src/com/chess/resources/img/chess_screenshots_settings.png)

Before the game starts, you will be able to adjust some parameters:
* __Color choice__: pieces of chosen color will be initialized at the bottom
* __Rule choice__: as there are some not-sure-if-I-like-this-rules, specific rules can be deactivated
* __Mode choice__: choose how players are controlled (by you or AI)
* __Difficulty choice__: the AI player difficulty can be controlled here. the highest setting is around the difficulty level 5-6 of Chess.com
* __Load__: here, you can load existing games from FEN or PGN code

### The game
![screenshot of game](https://github.com/lpapailiou/chess/blob/master/src/com/chess/resources/img/chess_screenshots_game.png)

The game can be played by clicking or by using drag&drop. For more information about how to handle the application see the [manual](https://github.com/lpapailiou/chess/blob/master/src/com/chess/resources/manual.html). If you are not very familiar with the chess game itself, there is an additional file which quickly explains the [rules](https://github.com/lpapailiou/chess/blob/master/src/com/chess/resources/rules.html).

#### The AI opponent
The AI opponent was created by using a minimax algorithm with alpha-beta-pruning. This means, that the opponent will simulate a few moves ahead and then choose the move which seems to avoid the worst situation while maximizing the chance to win.

Recursion depth: Simulates several moves ahead.

Piece values: Higher values for more powerful pieces.

Piece position: Knights and bishops perform better in central positions.

Randomness: Occasionally, the AI makes random moves to simulate human behavior.

Chess openings: The AI uses a library of chess openings for better initial positions.

Avoids stalemates and draws: Implements heuristics to avoid draws by repetition or insufficient material.


Depending on the rule and difficulty settings, the behavior of the AI opponent will change accordingly.
Example: On the highest difficulty setting we have a recursion depth of 4, while on the lowest difficulty setting we have a no recursion at all.

As the recursion depth has a huge impact on the speed of the caluclations (which increases exponentially), the maximum depth of 4 seemed a suitable compromise to get a more-or-less smart opponent, without having to wait 100 years for the next move.

#### Chess notations
During the game, the moves are logged to the console and can be exported as html file. Here, the __long algebraic notation (LAN)__ is used.  
Example for LAN: 

     e2-e4

For importing and exporting games, the __FEN__ and __PGN__ notations are used. These notations are widely used for chess games.    
  
The __FEN__ notation is a very compact one-line-code for a current board situation. It is useful if a board state should be quickly copied to be recreated later and/or in another chess program.  
Example for FEN: 

    rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1

The __PGN__ notation is more complex. It contains metadata about the game (players, location, round, etc.) and the complete list of moves. This means, a whole game can be recreated step by step, which is useful if you want to do analyzes.  
Example for PGN:

    [Event "Casual waste of time"]
    [Site "Your cave, SWITZERLAND"]
    [Date "2019.12.08"]
    [Round "2"]
    [White "Thought, Deep"]
    [Black "Blue, Deep"]
    [Result "0:1"]
    
    1. f4 d5 2. Nc3 d4 3. Nb5 a6 4. Na3 Bg4 5. h3 Bh5 6. d3 Nd7
    7. Bd2 e6 8. Nc4 Qh4+ 9. g3 Qxg3# 0:1

#### Editing a game
I really hated to implement this feature, as in a real chess game, steps should not be undone. Still, it's cool for whait-what-happened-moments or analyzing already played games.

#### Thoughts about this project
I did this project for fun and curiosity. The main motivation I was driven by was 'how do I get a nice chess game with a really smart AI' (and so far, I was not able to beat the AI myself).
As you will see in the code, many of the features (e.g. exports, edit mode) grew in in a quite organic way. If I was more serious about it, the architecture should have been restructured accordingly. 
The main issue of the AI opponent is the speed of the calculations, which limits the recursion depth to 4. Recursion depth could be increased if the move generation handling would be closer to machine code (i.e. bit shifting methods). After all, Java might not be the best programming language for that purpose.
Another issue is testability. As the coupling is not loose enough, I was not going too far with unit tests.
Some other time, I will do further work here or start again from scratch.

## Project structure

* ``com.chess.application``     this package contains the main method (in ``Chess.java``), as well as gui related classes
* ``com.chess.model``               enums, container classes, data classes
* ``com.chess.resources``        text and image files
* ``com.chess.root``        	       contains the 'game engine' (pieces, board, game handling, AI logic)

## How to get it

To clone the project, run the following command:

git clone [here](https://github.com/SoaibAkhtar321/Chess-Master.git)


##Technologies Used
This project integrates several technologies for a rich and interactive chess game:

##Back-End:

Java 8: Core logic and AI implementation.

JavaFX: Graphical user interface for the game.

Minimax Algorithm with Alpha-Beta Pruning: AI decision-making logic.

JSP & Servlets: Web-based components for dynamic content rendering.


##Front-End:

HTML5: Structure for the user interface.

CSS3: Styling and responsive design.

JavaScript: Interactive elements like drag-and-drop.

Bootstrap 4: Responsive, mobile-friendly layout.


##Game Logic & Data:

FEN: Board position representation for saving and loading games.

PGN: Game move and metadata format for export and analysis.


##Build & Dependency Management:

Apache Maven: Project automation and dependency management.

JUnit: Unit testing for game logic and AI.

Mockito: Mocking framework for unit tests.


##Version Control & Collaboration:

Git: Version control.

GitHub: Hosting platform for collaboration.


##Additional Tools & Libraries:

Log4j: Logging framework for debugging.

Apache Commons: Utility functions for common tasks.

JDBC: Database interaction for storing game data (if applicable).


##Development Tools:

IDE (IntelliJ IDEA, Eclipse,): For coding, debugging, and running the application.

Postman/REST Clients: API testing (if the game has web-based features).

##Testing

Unit tests are implemented using JUnit for testing various components of the game. These tests focus on:

Game logic: Ensuring rules, moves, and board states behave as expected.

AI behavior: Verifying AI move generation and decision-making processes.

UI components: Ensuring the interface correctly responds to user interactions.


You can run the tests using Maven:
mvn test

This will run all unit tests defined in the project and provide a summary of the results.



