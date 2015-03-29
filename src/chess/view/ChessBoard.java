package chess.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.*;
import javax.imageio.ImageIO;


public class ChessBoard extends JPanel {
	
	private ApplicationFrame frame;
	private JButton[][] chessBoardSquares = new JButton[6][6];
	private static final String COLS = "ABCDEF";
	private Image[][] chessPieceImages = new Image[2][6];
	private Image starImage;
	public static final int QUEEN = 0, KING = 1, ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = {
        ROOK, BISHOP, KNIGHT, KNIGHT, BISHOP, ROOK
    };
    public static final int BLACK = 0, WHITE = 1;
	
	public ChessBoard(ApplicationFrame frame)
	{
		this.frame = frame;
		
		this.setLayout(new GridLayout(0,7));
		this.setBorder(new CompoundBorder(
				new EmptyBorder(8,8,8,8),
				new LineBorder(Color.BLACK)
				));
		
		createImages();
		
		// Color ochre = new Color(204,119,34);
		this.setBackground(Color.GRAY);
		JPanel boardConstraint = new JPanel(new GridBagLayout());
		boardConstraint.setBackground(Color.GRAY);
		boardConstraint.add(this);
		frame.add(boardConstraint);
		
		// create the chess board squares
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                b.setOpaque(true);
                Border border = new LineBorder(Color.BLACK, 1);
                b.setBorder(border);
                if ((jj % 2 == 1 && ii % 2 == 1)
                        //) {
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[jj][ii] = b;
            }
        }
        
        for (int i = 0; i < 4; i++) {
            this.add(
                    new JLabel(""));
        }
        this.add(new JLabel("Score:"));
        this.add(new JLabel("0"));
        this.add(new JLabel("0"));
        
        
        this.add(new JLabel(""));
        // fill the top row
        for (int i = 0; i < 6; i++) {
            this.add(
                    new JLabel(COLS.substring(i, i + 1),
                    SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                switch (j) {
                    case 0:
                        this.add(new JLabel("" + (7-(i + 1)),
                                SwingConstants.CENTER));
                    default:
                        this.add(chessBoardSquares[j][i]);
                }
            }
        }
        setupNewGame();
		
		
	}
	
	private final void createImages() {
        try {
        	InputStream chessPieces = ClassLoader.getSystemResourceAsStream("chess_pieces.png");
            // URL url = new URL("http://i.stack.imgur.com/memI0.png");
            BufferedImage bi = ImageIO.read(chessPieces);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 6; j++) {
                    chessPieceImages[i][j] = bi.getSubimage(
                            j * 64, i * 64, 64, 64);
                }
            }
            
            InputStream star = ClassLoader.getSystemResourceAsStream("star.png");
            starImage = ImageIO.read(star).getScaledInstance(64,64, Image.SCALE_SMOOTH);
            

            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
	
	private final void setupNewGame() {
        // set up the black pieces
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][0].setIcon(new ImageIcon(
                    chessPieceImages[BLACK][STARTING_ROW[ii]]));
        }
        
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][2].setIcon(new ImageIcon(
                    starImage));
        }
        
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][3].setIcon(new ImageIcon(
                    starImage));
        }
        
        
//        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
//            chessBoardSquares[ii][1].setIcon(new ImageIcon(
//                    chessPieceImages[BLACK][PAWN]));
//        }
//        // set up the white pieces
//        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
//            chessBoardSquares[ii][4].setIcon(new ImageIcon(
//                    chessPieceImages[WHITE][PAWN]));
//        }
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][5].setIcon(new ImageIcon(
                    chessPieceImages[WHITE][STARTING_ROW[ii]]));
        }
    }
	
	private void highlightSquare(int x, int y) {
		
		JButton square = chessBoardSquares[x][y];
		LineBorder border = new LineBorder(Color.RED, 4);
		square.setBorder(border);	
		
	}
	
	private void unhighlightSquare(int x, int y) {
		
		JButton square = chessBoardSquares[x][y];
		Border emptyBorder = new LineBorder(Color.BLACK, 1);
		square.setBorder(emptyBorder);
		
	}

}
