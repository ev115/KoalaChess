package chess.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// combining pieces in the board
public class CombinedPiece extends NormalPiece {
	
	public NormalPiece piece1;
	public NormalPiece piece2;
	public NormalPiece piece3;
	
	// combined two pieces
	public CombinedPiece(NormalPiece piece1, NormalPiece piece2,
											Square currPostion) {
		super(piece1.player, currPostion);
		
		this.piece1 = piece1;
		this.piece2 = piece2;
		this.piece3 = null;
	}

	// combined three pieces
	public CombinedPiece(NormalPiece piece1, NormalPiece piece2, 
							NormalPiece piece3, Square currPostion) {
		
		super(piece1.player, currPostion);
		
		this.piece1 = piece1;
		this.piece2 = piece2;
		this.piece3 = piece3;

	}
	
	@Override
	public Square[] calculateAvailableSquares() {
		// combine the all the available squares
		
		// copy the available Squares in piece1
		int totalSquares = piece1.availableSquares.length;
		System.arraycopy(piece1.availableSquares, 0, this.availableSquares, 0, totalSquares );
		
		// copy the available Squares in piece2
		totalSquares = availableSquares.length + piece2.availableSquares.length;
		System.arraycopy(piece2.availableSquares, 0, this.availableSquares, 0, totalSquares );
		
		// if there is a 3rd piece
		if (piece3 != null){
			// copy available Squares in piece3
			totalSquares = availableSquares.length + piece3.availableSquares.length;
			System.arraycopy(piece3.availableSquares, 0, this.availableSquares, 0, totalSquares );
		}
		
		//remove duplicate squares gathered from different pieces
		removeDuplicates(availableSquares);
		
		
		return availableSquares;
	}
	
	public Square[] removeDuplicates(Square[] squaresList){

		// use set to remove duplicate values
		Set<String> infos = new HashSet<String>();
		
		// use list to record new array without having
		// to declare array size
		List<Square> sqList = new ArrayList<Square>();
		
		// for each square in squaresList
		for(Square sq: squaresList){
			// record the coordinates into a string
			String coordinates = 
					Integer.toString(sq.posX) +
					Integer.toString(sq.posY);
			
			//try add this coordinates to the hash
			if (infos.add(coordinates)){
				// no duplicates
				// add this to our new list
				sqList.add(sq);
			}
			
		}
		
		// extract array from new array list
		squaresList = sqList.toArray(new Square[sqList.size()]);
		
		return squaresList;
	}
	
}
