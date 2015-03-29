package chess.model;

public class Rook extends NormalPiece {

	public Rook(int player, Square currPostion) {
		super(player, currPostion);
	}

	@Override
	public Square[] calculateAvailableSquares() {
		
		// TODO
		
		// do rook available squares algorithm here
		
		// set availableSquares variable
		return availableSquares;
	}

}
