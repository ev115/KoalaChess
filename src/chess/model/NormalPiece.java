package chess.model;

 // Used by normal chess pieces 
 // - rook, knight and bishop 
public abstract class NormalPiece extends Piece 
{
	public Square currPosition;
	public int player;
	
	public Square[] availableSquares;
	
	public NormalPiece(int player, Square currPostion){
		this.points = 5;
		this.currPosition = currPostion;
		this.player = player;
	}
	
	// changes a piece's position (coordinates)
	public void movePiece(int x, int y){
		this.currPosition.posX = x;
		this.currPosition.posY = y;
	}
	
	public abstract Square[] calculateAvailableSquares();
	
}
