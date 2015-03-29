package chess.model;

// Board Squares Object
public class Square 
{
	// stores square coordinates
    public int posX;
	public int posY;
	
	// the piece that is currently placed
	// in this square object
	public Piece piece;
	
	// mainly used as a guide for the view 
	public Boolean highlighted = false;

	public Boolean available = true;
	
	//constructor
	public Square(int posX, int posY, Piece piece){
		this.posX = posX;
		this.posY = posY;
		this.piece = piece;
	}
	//constructor 2 - without a piece
	public Square(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
		this.piece = null;
	}

	/*TODO: remove this section if proven not needed
	 * 
	 * Note: I think we wouldn't be needing 
	 * these methods as we can just do direct access on them.
	 * eg:  squareObject.piece = pieceObject;
	 * 
	public void putPiece(Piece piece) {
		this.piece = piece;
	}

	public void setHighlight() {
		this.highlighted = true;
	}

	public void removeHighlight() {
		this.highlighted = false;
	}
	*/
}
