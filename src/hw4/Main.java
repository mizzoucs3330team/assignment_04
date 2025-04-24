package hw4;

import hw4.game.Game;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Game game = new Game(7); // 3-7
		System.out.println("Game Start!");
		boolean lost = true;
		Scanner scanner = new Scanner(System.in);

		while(lost == true){
			System.out.println("");
			game.printGrid();

			System.out.println("\nChoose direction to move");
			String dir = scanner.nextLine();

			//move left
			if (scanner.equals("left")
			|| scanner.equals("Left")
			|| scanner.equals("LEFT")
			|| scanner.equals("l")
			|| scanner.equals("L")){
				boolean valid = moveLeft();
				if (!valid) System.out.println("\nBONK!");
			}

			//move right
			else if (scanner.equals("right")
			|| scanner.equals("Right")
			|| scanner.equals("RIGHT")
			|| scanner.equals("r")
			|| scanner.equals("R")){
				boolean valid = moveRight();
				if (!valid) System.out.println("\nBONK!");
			}

			//move up
			else if (scanner.equals("up")
			|| scanner.equals("Up")
			|| scanner.equals("UP")
			|| scanner.equals("u")
			|| scanner.equals("U")){
				boolean valid = moveUp();
				if (!valid) System.out.println("\nBONK!");
			}

			//move down
			else if (scanner.equals("down")
			|| scanner.equals("Down")
			|| scanner.equals("DOWN")
			|| scanner.equals("d")
			|| scanner.equals("D")){
				boolean valid = moveDown();
				if (!valid) System.out.println("\nBONK!");
			}

			//invalid
			else {
				System.out.println("\nInvalid choice");
			}

		}
	}
	
	public static boolean moveLeft(){

		return false;
	}
	public static boolean moveRight(){
		
		return false;
	}
	public static boolean moveUp(){
		
		return false;
	}
	public static boolean moveDown(){
		
		return false;
	}
}
