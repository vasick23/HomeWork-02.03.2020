package com.chessmaster.pieces;

import com.chessmaster.config.PieceColor;

public class Rook extends Piece{
	public Rook(PieceColor color, int row, int col) throws Exception {	
		super(color, "R", row, col);
		this.power  = 5;
		this.id 	= 4;
	}
	public boolean isMoveActionValidForRook(int moveRow, int moveCol) {
		int moveRowCoeficient = this.row - moveRow;
		int moveColCoeficient = this.col - moveCol;
		boolean isRowMoveValid = false;
		boolean isColMoveValid = false;
		if((moveRowCoeficient >= 0) && (moveColCoeficient <= 0)) {
			isColMoveValid = true;
			isRowMoveValid = true;
		}
		return isRowMoveValid & isColMoveValid;
	}
	public void move(int row, int col) {
		if(isMoveActionValidForRook(row, col)) {
			this.row = row;
			this.col = col;
		}
	}	
	public void renderRook() {	
	}
	public boolean isAttackForRook(int attackRow, int attackCol) {
		int attackRowCoeficient = this.row - attackRow;
		int attackColCoeficient = this.col - attackCol;
		boolean isRowAttackValid = false;
		boolean isColAttackValid = false;
		if((attackRowCoeficient >= 0) && (attackColCoeficient <= 0)) {
			isColAttackValid = true;
			isRowAttackValid = true;
		}
		return isRowAttackValid & isColAttackValid;
	}
	@Override
	public void attack(int attackRow, int attackCol) {
		if(isAttackForRook(attackRow, attackCol)) {
			this.row = attackRow;
			this.col = attackCol;
		}
	}
	public void blast() {
	}
	@Override
	public boolean isMoveActionValid(int row, int col) {
		return false;
	}
}
