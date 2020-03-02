package com.chessmaster.pieces;

import com.chessmaster.config.PieceColor;

public class Bishop extends Piece{	
public Bishop(PieceColor color, int row, int col) throws Exception {		
		super(color,"B",  row, col);
		this.power  = 5;
		this.id 	= 2;
	}
	public boolean isMoveDiagonalForBishop(int moveRow, int moveCol) {
		int moveRowCoeficient = this.row - moveRow;
		int moveColCoeficient = this.col - moveCol;
		int StartPosition = this.row + this.col;
		int NextPosition = moveRow + moveCol;
		boolean isDiagonalValid = false;
		if(StartPosition == NextPosition) {
			isDiagonalValid = true;
		}else {
			if(moveRowCoeficient == moveColCoeficient) {
				isDiagonalValid = true;
			}
		}
		return isDiagonalValid;
	}
	public void move(int row, int col) {
		if(isMoveDiagonalForBishop(row, col)) {
			this.row = row;
			this.col = col;
		}
	}
	public void renderBishop() {
	}
	public boolean isAttackForBishop(int attackRow, int attackCol) {
		int StartPosition = this.row + this.col;
		int NextPosition = attackRow + attackCol;
		int moveRowCoeficient = this.row - attackRow;
		int moveColCoeficient = this.col - attackCol;
		boolean isAttack = false;
		if(StartPosition == NextPosition) {
			isAttack = true;
		}else {
			if(moveRowCoeficient == moveColCoeficient) {
				isAttack = true;
			}
		}
		return isAttack;
	}
	@Override
	public void attack(int attackRow, int attackCol) {
		if(isAttackForBishop(attackRow, attackCol)) {
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