package com.chessmaster.pieces;

import com.chessmaster.config.PieceColor;

public class Chudaka extends Piece implements Blastable{
public Chudaka(PieceColor color, int row, int col) throws Exception {	
		super(color, "Cd", row, col);
		this.power 	= 15;
		this.id 	= 7;
	}
	public boolean isMoveActionValidForChudaka(int moveRow, int moveCol) {
		int moveRowCoeficient = this.row - moveRow;
		int moveColCoeficient = this.col - moveCol;
		boolean isRowMoveValid = (moveRowCoeficient == 1);
		boolean isColMoveValid = (moveColCoeficient == 0);
		return isRowMoveValid && isColMoveValid;
	}
	@Override
	public void move(int moveRow, int moveCol) {
		if(isMoveActionValidForChudaka(row, col)) {
			this.row = moveRow;
			this.col = moveCol;
		}
	}
	public boolean isAttackForChudaka(int attackRow, int attackCol) {
		int attackRowCoeficient = this.row - attackRow;
		int attackColCoeficient = this.col - attackCol;
		boolean isRowAttackValid = (attackRowCoeficient == 1);
		boolean isColAttackValid = (attackColCoeficient <= 0);
		return isRowAttackValid && isColAttackValid;
	}
	@Override
	public void attack(int attackRow, int attackCol) {	
		if(isAttackForChudaka(attackRow, attackCol)) {
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
