package chess.view;

import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class ApplicationFrame extends JFrame {
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem restart;
	private JMenuItem exit;
	private ChessBoard chessBoard;
	private Scoreboard scoreboard;
	
	public ApplicationFrame()
	{
		chessBoard = new ChessBoard(this);
		scoreboard = new Scoreboard(this);
		this.setLayout(new BorderLayout());
		this.add(chessBoard, BorderLayout.CENTER);
		this.add(scoreboard, BorderLayout.EAST);
		
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		
		menuBar.add(menu);
		restart = new JMenuItem("Restart");
		exit = new JMenuItem("Exit");
		// exit.addActionListener(new ExitActionListener(this));
		menu.add(restart);
		menu.add(exit);
		
		this.setJMenuBar(menuBar);
		this.setSize(500,400);
		this.setBounds(100,100,800,600);
		this.setVisible(true);
	}
	
	// window event handler to prompt for user confirmation when exiting
    protected void processWindowEvent(WindowEvent e) 
    {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) 
        {     
            int exit = JOptionPane.showConfirmDialog(this, 
                        "Are you sure you want to exit?", "Confirm Exit",2);
            if (exit == JOptionPane.YES_OPTION) 
            {
                System.exit(0);
            } 
        } 
        else 
        {
            super.processWindowEvent(e);
        }
    }

}
