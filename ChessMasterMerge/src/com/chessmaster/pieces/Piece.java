package com.chessmaster.pieces;
import com.chessmaster.config.PieceColor;
public abstract class Piece {
	protected PieceColor color;
	protected int power;
	protected int id;
	protected int row;
	protected int col;
	protected String signature;
	public Piece(PieceColor color, String signature, int row, int col) throws Exception {
		this.color 	= color;
		this.row 	= row;
		this.col 	= col;
		this.signature = signature;
	}
	public Piece(PieceColor color) {	
		this.color 	= color;
		this.row 	= 0;
		this.col 	= 0;
	}
    public void setRow(int row) {
		if(row >= 0 && row <= 9) {
			this.row = row;
		}
	}
	public int getRow() {
		return this.row;
	}
	public void setCol(int col) {
		if(col >= 0 && col <= 9) {
			this.col = col;
		}
	}	
	public int getCol() {
		return this.col;
	}
	public String getSignature() {
		return (this.color == PieceColor.WHITE) 
				? ("w" + this.signature)
			    : ("b" + this.signature);
	}
	public abstract boolean isMoveActionValid(int row, int col);
	public void move(int row, int col) {	
		if(isMoveActionValid(row, col)) {	
			this.row = row;
			this.col = col;
		}
	}
	public abstract void attack(int row, int col);
}