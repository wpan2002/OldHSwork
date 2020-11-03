

import java.io.IOException;
import java.util.Scanner;


public class Game  {
	static Scanner scanner = new Scanner(System.in);
	
	public static char getResponse() {		
		System.out.println("Input 'y' or 'n'");
		
		char answer=  scanner.next(".").charAt(0);
		scanner.nextLine();//consume the return!
		return answer;
	}
	
	
	
	public static void clearScreen() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void displayMenu() {
		System.out.println("input x to eXit");
		System.out.println("input s to Save");
		System.out.println("input l to Load");
		System.out.println("input a to Load Animal Questions");		
		System.out.println("input d to Display Tree");
		System.out.println("Input any other key to continue");
	}
	
	

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		char input;
		Questions game = new Questions();			
		game.addFirstQuestion("Is it a mammal", "dog","fish");		
		clearScreen();
		displayMenu();
		input =  scanner.next(".").charAt(0);
		
		do  {
			
			if (input == 'l') {
				game = Questions.loadGame();
				game.startGame();
				displayMenu();
				input =  scanner.next(".").charAt(0);
			}
			else if (input == 's') {
				Questions.saveGame(game);
				game.startGame();
				displayMenu();
				input =  scanner.next(".").charAt(0);
			}
			else if (input == 'd') {
				Questions.printBinaryTree(game.firstQuestion,0);				
				displayMenu();
				input =  scanner.next(".").charAt(0);
			}
			else if (input == 'a') {
				game = Questions.loadAnimalGame();
				game.startGame();
				displayMenu();
				input =  scanner.next(".").charAt(0);
			}		
			
			else {
						
				if ( !game.currentQuestion.isQuestion) {
					System.out.println("Is it a "+game.currentQuestion.question);
					input = getResponse();
					if (input == 'y') {
						System.out.println("I know everything!!");
						game.startGame();
						displayMenu();					
					}
					else {
						addNewQuestion(game);
						game.startGame();
						displayMenu();					
					}				
				}
				
				else {
					System.out.println(game.ask());
					input = getResponse();					
					game.nextQuestion(input =='y');
				
				}					
			}
			
		} while (input != 'x'); 
		
		System.out.println("Game Over");
		scanner.close();
	}

	private static void addNewQuestion(Questions game) {
		char input;
		System.out.println("I thought I knew everything!");
		System.out.println("Tell me what it was");		
				
		String newAnswer = scanner.nextLine();				
	
		System.out.println("What yes or no queston would you ask for a "+newAnswer);
		String newQuestion = scanner.nextLine();	
									
		System.out.println("Would your answer be y or n to this question?");
		input = getResponse();					
		
		game.addNewQuestion(newQuestion, newAnswer, input == 'y');		
	
	}

}
