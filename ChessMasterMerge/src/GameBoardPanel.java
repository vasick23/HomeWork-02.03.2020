import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {
	private static final long serialVersionUID = 4;
	private final int TILE_SIDE = 50;
	private int selectedRow = -1;
	private int selectedCol = -1;
	private int clicks = 0;
	String Player;
	final String player1 = "Player1";
	final String player2 = "Player2";
	public GameBoardPanel() {
		clicks = 1;
		addMouseListener(new ChessBoardEventProxy() {	
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				selectedRow = y / TILE_SIDE; 
				selectedCol = x / TILE_SIDE;
				System.out.println(selectedRow + ";" + selectedCol);
				updateUI();
			}
		});
	}

	public void paint(Graphics g) {
		for(int row = 0; row < 10; row++) {
			for(int col = 0; col < 10; col++) {
				render(g, row, col);
				if((row == 8 || row == 9) && col != 8 && col != 9)  {
					WhitePiece(g, row, col);
					}
					if((row == 1 || row == 0) && col != 8 && col != 9)  {
					BlackPiece(g, row, col);
				    }
			}
		}
	}
	
	private void render(Graphics g, int row, int col) {
		boolean isRowEven 	= (row % 2 == 0);
		boolean isColEvent 	= (col % 2 == 0);
		boolean isWhite 	= (isRowEven && isColEvent) ||
							  (!isRowEven && !isColEvent);
		Color tileColor = isWhite ? Color.WHITE 
								  : Color.BLACK;
		boolean isSelected = (row == selectedRow) && 
							 (col == selectedCol);
		int tileX = col * TILE_SIDE;
		int tileY = row * TILE_SIDE;
		if(isSelected && clicks == 1) {
			tileColor = Color.RED;
			g.setColor(tileColor);
			g.fillRect(tileX, tileY, TILE_SIDE, TILE_SIDE);
			clicks = 2;
			return;
		} else if (isSelected && clicks == 2) {
			tileColor = Color.BLUE;
			g.setColor(tileColor);
			g.fillRect(tileX, tileY, TILE_SIDE, TILE_SIDE);
			clicks = 1;
			return;
		}
		g.setColor(tileColor);
		g.fillRect(tileX, tileY, TILE_SIDE, TILE_SIDE);
	}
	
	public void WhitePiece(Graphics g, int row, int col){
		int tileX = col * TILE_SIDE;
		int tileY = row * TILE_SIDE;
	    g.setColor(Color.LIGHT_GRAY);
	    g.fillOval(tileX, tileY, TILE_SIDE, TILE_SIDE);
	}
	public void BlackPiece(Graphics g, int row, int col){
		int tileX = col * TILE_SIDE;
		int tileY = row * TILE_SIDE;
	    g.setColor(Color.DARK_GRAY);
	    g.fillOval(tileX, tileY, TILE_SIDE, TILE_SIDE);
	}
}