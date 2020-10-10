import java.util.Random;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		System.out.println("************");
		System.out.println("Tic Tac Toe!");
		System.out.println("************");
		System.out.println("Please enter the column (A, B or C) and then the row (1, 2, or 3) of your move.");
		game.printBoard();
		
		while(true)
		{
		if (game.itsPlayersTime())
		{
		Scanner scan = new Scanner(System.in);
		System.out.println("Player Move (X): ");
		String playersChoice = scan.nextLine();
		char c1 = playersChoice.charAt(0);
		char c2 = playersChoice.charAt(1);
		int x2 = Character.getNumericValue(c2);
		
		while ((c1!='A' && c1!='B' && c1!='C') || (x2!=1 && x2!=2 && x2!=3))
		{
			System.out.println("Invalid Input: Please enter the column and row of your move (Example: A1).");
			
			scan = new Scanner(System.in);
			System.out.println("Player Move (X): ");
			playersChoice = scan.nextLine();
			
			c1 = playersChoice.charAt(0);
			c2 = playersChoice.charAt(1);
			x2 = Character.getNumericValue(c2);
		}
		int x1;
		if (c1 == 'A')
			x1 = 0;
		else if (c1 == 'B')
			x1 = 1;
		else
			x1 = 2;
		x2--;
		
		while (game.isTaken(x1, x2)) {
			System.out.println("The space entered is already taken.");
			scan = new Scanner(System.in);
			System.out.println("Player Move (X): ");
			playersChoice = scan.nextLine();
			c1 = playersChoice.charAt(0);
			c2 = playersChoice.charAt(1);
			x2 = Character.getNumericValue(c2);
			if (c1=='A')
				x1=1;
			else if (c1=='B')
				x1=2;
			else
				x1=3;
		}
		game.nextMove(x1, x2);
		}
		else
		{
			Random rand = new Random();
			int  n1 = rand.nextInt(3) + 1;
			int n2 = rand.nextInt(3) + 1;
			while (game.isTaken(n1-1, n2-1))
			{
				rand = new Random();
				n1 = rand.nextInt(3) + 1;
				n2 = rand.nextInt(3) + 1;
			}
			
			char r1;
			if (n1 == 1)
				r1 = 'A';
			else if (n1 == 2)
				r1 = 'B';
			else
				r1 = 'C';
			
			System.out.println("Computer Move (O): " + r1 + n2);
			game.nextMove(n1-1, n2-1);
		}
		
		game.printBoard();
		
		
		if (game.isWin()) {
			if (game.itsPlayersTime()) {
			System.out.println("You win!");
			System.exit(0);
			}
			else
			{
				System.out.println("Computer wins :(");
				System.exit(0);
			}
		}
		
		if (game.isTie()) {
			System.out.println("Game is tied!");
			System.exit(0);
		}
		
		game.changePlayer();
		}

	}

}
