import java.awt.BorderLayout;

import javax.swing.*;

import com.chessmaster.manager.GameBoard;
public class ApplicationMain{
	public static void main(String[] args){		
		GameBoard.init();
		JFrame windowFrame = new JFrame();
		JLabel statusbar = new JLabel("Problem and game info will be displayed here.");
		windowFrame.add(statusbar, BorderLayout.SOUTH);
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setSize(520, 545);
		windowFrame.setResizable(false);
		windowFrame.add(new GameBoardPanel());	
		windowFrame.setVisible(true);
	}
}