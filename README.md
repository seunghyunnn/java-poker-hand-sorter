# Poker Hand Sorter

This is a program written in Java that reads pairs of poker hands for two players and determines how many times each player wins.

## Input Format
This program reads from standard input (stdin),either from a file or directly from the terminal. 
Each line of input should contain 10 cards, where 
- first 5 cards are Player1's hand, 
- last 5 cards are Player2's hand. 

For example,

```agsl
2D 3H 4S 5C 6D 7H 8S 9C TD JH
```
This means: 
- Player1 has: 2 Diamond, 3 Heart, 4 Spade, 5 Club, and 6 Diamond
- Player2 has: 7 Heart, 8 Spade, 9 Club, 10 Diamond, Jack Heart
 
## Output Format

This program prints the number of hands won by each player.

```agsl
Player 1: 263 hands.
Player 2: 237 hands. 
```
This means Player1 won 263 hands and Player2 won 237 hands.

## Running the Program
To run the program, use the following command and type the input line by line in the terminal:  
```agsl
java -jar my-poker-solution.jar
```
If you want to use a file as input, run: 
```agsl
cat <file/path/filename.txt> | java -jar my-poker-solution.jar
```
The program includes one example input file under `src/resources/` called `pocker-hands.txt`. To run the program with this example file: 
```agsl
cat src/resources/poker-hands.txt | java -jar my-poker-solution.jar
```


