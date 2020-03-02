package com.chessmaster.pieces;

import com.chessmaster.config.PieceColor;

public class Knight extends Piece{
public Knight(PieceColor color, int row, int col) throws Exception {	
		super(color, "Kn", row, col);
		this.power  = 5;
		this.id 	= 3;
	}
	public boolean isMoveActionValidForKnight(int moveRow, int moveCol) {
		int moveRowCoeficient = this.row - moveRow;
		int moveColCoeficient = this.col - moveCol;
		boolean isRowMoveValid = false;
		boolean isColMoveValid = false;
		if((moveRowCoeficient <= 2)) {
			if(moveColCoeficient < 0) {
				if(moveColCoeficient >= -2){
					isColMoveValid = true;
					isRowMoveValid = true;
				}
			}else {
				if(moveColCoeficient > 0) {
					if(moveColCoeficient <= 2){
						isColMoveValid = true;
						isRowMoveValid = true;
					}
				}
			}	
		}
		return isRowMoveValid && isColMoveValid;
	}
	public void move(int row, int col) {
		if(isMoveActionValidForKnight(row, col)) {
			this.row = row;
			this.col = col;
		}
	}
	public void renderKnight() {	
	}
	public boolean isAttackForKnight(int attackRow, int attackCol) {
		int AttackRowCoeficient = this.row - attackRow;
		int AttackColCoeficient = this.col - attackCol;
		boolean isRowAttackValid = false;
		boolean isColAttackValid = false;
		if((AttackRowCoeficient <= 2)) {
			if(AttackColCoeficient < 0) {
				if(AttackColCoeficient >= -2){
					isColAttackValid = true;
					isRowAttackValid = true;
				}
			}else {
				if(AttackColCoeficient > 0) {
					if(AttackColCoeficient <= 2){
						isColAttackValid = true;
						isRowAttackValid = true;
					}
				}
			}	
		}
		return isRowAttackValid && isColAttackValid;
	}
	@Override
	public void attack(int attackRow, int attackCol) {
		if(isAttackForKnight(attackRow, attackCol)) {
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
