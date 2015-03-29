package chess.model;

// Board Object
public class Board {
	
	// 2D array - will contain coordinates of Squares
	public Square[][] boardSquares;
	
	
	public void initializeBoard() {
		// TODO
		// initialise players
		
		// initialise Square objects here
				// for each square object initialise a Piece
				// (if position requires a piece)
					// will use player objects here - recorded on piece
			// put this square object in the boardSquares 2D array

	}
	
	// access 
	public Square getSquare(int x, int y){
		return this.boardSquares[x][y];
	}

}
