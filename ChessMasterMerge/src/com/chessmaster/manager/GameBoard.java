package com.chessmaster.manager;

import com.chessmaster.config.PieceColor;
import com.chessmaster.pieces.*;

public class GameBoard {
	
	public static Piece board[][] = new Piece[10][10];
	public static final int MAX_BOARD_SIZE = 10;
	public static final int INIT_BOARD_WHITE_MAIN_PIECE_POCITION = 9;
	public static final int INIT_BOARD_BLACK_MAIN_PIECE_POCITION = 0;
	
	public static final int INIT_BOARD_WHITE_EXTRA_PIECE_POCITION = 8;
	public static final int INIT_BOARD_BLACK_EXTRA_PIECE_POCITION = 1;
	
	public static Piece activePiece;
	
	public static void init() {
		try {
			board[INIT_BOARD_BLACK_MAIN_PIECE_POCITION][0] = new Rook(PieceColor.BLACK, 0, 0);
			board[INIT_BOARD_BLACK_MAIN_PIECE_POCITION][1] = new Knight(PieceColor.BLACK, 0, 1);
			board[INIT_BOARD_BLACK_MAIN_PIECE_POCITION][2] = new Bishop(PieceColor.BLACK, 0, 2);
			board[INIT_BOARD_BLACK_MAIN_PIECE_POCITION][3] = new King(PieceColor.BLACK, 0, 3);
			board[INIT_BOARD_BLACK_MAIN_PIECE_POCITION][4] = new Queen(PieceColor.BLACK, 0, 4);
			
			board[INIT_BOARD_BLACK_EXTRA_PIECE_POCITION][0] = new Pawn(PieceColor.BLACK, 1, 0);
			board[INIT_BOARD_BLACK_EXTRA_PIECE_POCITION][1] = new Pawn(PieceColor.BLACK, 1, 1);
			board[INIT_BOARD_BLACK_EXTRA_PIECE_POCITION][2] = new Pawn(PieceColor.BLACK, 1, 2);
			board[INIT_BOARD_BLACK_EXTRA_PIECE_POCITION][3] = new Pawn(PieceColor.BLACK, 1, 3);
			board[INIT_BOARD_BLACK_EXTRA_PIECE_POCITION][4] = new Pawn(PieceColor.BLACK, 1, 4);		
			
	        board[9][0] = new Rook(PieceColor.WHITE, 9, 0);
			board[9][1] = new Knight(PieceColor.WHITE, 9, 1);
			board[9][2] = new Bishop(PieceColor.WHITE, 9, 2);
			board[9][3] = new King(PieceColor.WHITE, 9, 3);
			board[9][4] = new Queen(PieceColor.WHITE, 9, 4);
			
			board[8][0] = new Pawn(PieceColor.WHITE, 8, 0);
			board[8][1] = new Pawn(PieceColor.WHITE, 8, 1);
			board[8][2] = new Pawn(PieceColor.WHITE, 8, 2);
			board[8][3] = new Pawn(PieceColor.WHITE, 8, 3);
			board[8][4] = new Pawn(PieceColor.WHITE, 8, 4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean isPieceSelectable(int row, int col) {
		return board[row][col] != null;
	}
	public static void selectPiece(int row, int col) {
		activePiece = board[row][col];
	}
	public static boolean isPieceMoveValid(int row, int col) {
		return activePiece.isMoveActionValid(row, col);
	}
	public static void move(int row, int col) {
		int currentRow = activePiece.getRow();
		int currentCol = activePiece.getCol();
		board[row][col] = activePiece;
		activePiece.move(row, col);
		board[currentRow][currentCol] = null;
	}
	public static void render() {
		Piece currentPiece;
		String signature;
		for(int i = 0; i < MAX_BOARD_SIZE; i++) {
			for(int j = 0; j < MAX_BOARD_SIZE; j++) {
				currentPiece = board[i][j];
				signature 	 = (currentPiece == null) 
								? "* " 
								:   currentPiece.getSignature() + " ";
				System.out.print(signature);
			}
			System.out.println();
		}
	}
}