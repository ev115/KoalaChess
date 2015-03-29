package chess.view;

import java.awt.*;

import javax.swing.*;

public class Scoreboard extends JPanel {
	
	private ApplicationFrame frame;
	private JLabel blackScore = new JLabel("0");
	private JLabel whiteScore = new JLabel("0");
	
	public Scoreboard(ApplicationFrame frame)
	{
		this.frame = frame;
		
		this.setLayout(new GridLayout(0,2));
		this.add(blackScore);
		this.add(whiteScore);
		
	}

}
