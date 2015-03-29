package chess.model;

public class Player {
	
	public int score;
	public Boolean playersTurn;
	public int moves;
	
	public Player(){
		this.score = 0;
		this.playersTurn = false;
	}
	
	public int appendScore(int score){
		this.score = this.score + score;
		return this.score;
	}
	
	// maybe this might become redundant
	// but just putting it here for now
	public void appendPlayerMoves(){
		this.moves++;
	}
	
	
}
