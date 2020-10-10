
public class TicTacToe {
	private char[][] board;
	private char whoPlays;
	
	public TicTacToe(){
		board = new char[3][3];
		whoPlays = 'X' ;
		emptyBoard();
	}
	
	public void emptyBoard()
	{
		for (int i=0;i<3;i++)
			for (int j=0;j<3;j++)
				board[i][j]=' ';
	} 
	
	public void printBoard()
	{
		for (int i=0;i<3;i++) {
			System.out.print("| ");
			for (int j=0;j<3;j++) {
				System.out.print(board[i][j] + " | ");} 
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean isTie()
	{
		boolean tieCheck = true;
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				if (board[i][j] == ' ')
					tieCheck = false;
			}
		}
		return tieCheck;
	}
	
	public boolean isWin()
	{
		return (rowsCheck() || collumnsCheck() || crossCheck());
	}
	
	private boolean rowsCheck()
	{
		for (int i =0;i<3;i++)
			if (winnerCheck(board[i][0], board[i][1], board[i][2]) == true )
				return true;
		return false;
	}
	
	private boolean collumnsCheck()
	{
		for (int i =0;i<3;i++)
			if (winnerCheck(board[0][i], board[1][i], board[2][i]) == true )
				return true;
		return false;
	}
	
	private boolean crossCheck()
	{
		return (winnerCheck(board[0][0], board[1][1], board[2][2]) == true);
	}
	
	private boolean winnerCheck(char c1, char c2, char c3)
	{
		return ((c1 != ' ') && (c1 == c2) && (c2 == c3));
	}

	public void changePlayer()
	{
		if (whoPlays == 'X')
			whoPlays = 'O';
		else
			whoPlays = 'X';
	}
	
	public void nextMove(int x, int y)
	{
		board[x][y] = whoPlays;
	}
	
	public boolean isTaken(int x, int y)
	{
		return (board[x][y] != ' ');
	}
	
	public boolean itsPlayersTime()
	{
		return (whoPlays == 'X');
	}
}
	
