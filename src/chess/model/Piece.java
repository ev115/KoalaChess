package chess.model;

public abstract class Piece {
	public int points;
	
	public int calculatePoints(int currentPoints){
		
		int totalPoints = this.points + currentPoints;
		
		return totalPoints;
	}
}
