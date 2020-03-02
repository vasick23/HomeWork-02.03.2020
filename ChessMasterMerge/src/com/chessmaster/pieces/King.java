package com.chessmaster.pieces;

import com.chessmaster.config.PieceColor;

public class King extends Piece{
public King(PieceColor color, int row, int col) throws Exception {
		super(color, "K", row, col);
		this.power  = 6;
		this.id 	= 5;
	}
	public boolean isMoveActionValidForKing(int moveRow, int moveCol) {
		int moveRowCoeficient = this.row - moveRow;
		int moveColCoeficient = this.col - moveCol;		
		boolean isRowMoveValid = false;
		boolean isColMoveValid = false;
		if((moveRowCoeficient <= 1) && (moveColCoeficient == 0)) {
			isColMoveValid = true;
			isRowMoveValid = true;
		}else {
			if((moveRowCoeficient == 0)&& (moveColCoeficient <= 1)) {
				isColMoveValid = true;
				isRowMoveValid = true;
			}
		}
		return isRowMoveValid && isColMoveValid;
	}
	public boolean isMoveDiagonalForKing(int moveRow, int moveCol) {
		int StartPosition = this.row + this.col;
		int NextPosition = moveRow + moveCol;
		boolean isDiagonalValid = false;
		if(StartPosition == NextPosition) {
			isDiagonalValid = true;
		}else {
			if(StartPosition == (NextPosition + 2)) {
				isDiagonalValid = true;
			}else {
				if(StartPosition == (NextPosition - 2)) {
					isDiagonalValid = true;
				}
			}
		}
		return isDiagonalValid;
	}	
	public void move(int row, int col) {
		if((isMoveActionValidForKing(row, col)) && (isMoveDiagonalForKing(row, col))) {
			this.row = row;
			this.col = col;
		}
	}
	public void renderKing() {
		
	}
	public boolean isAttackForKing(int attackRow, int attackCol) {
		int StartPosition = this.row + this.col;
		int NextPosition = attackRow + attackCol;
		boolean isAttack = false;
		if(StartPosition == NextPosition) {
			isAttack = true;
		}else {
			if(StartPosition == (NextPosition + 2)) {
				isAttack = true;
			}else {
				if(StartPosition == (NextPosition - 2)) {
					isAttack = true;
				}
			}
		}
		return isAttack;
	}
	@Override
	public void attack(int attackRow, int attackCol) {
		if(isAttackForKing(attackRow, attackCol)) {
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
