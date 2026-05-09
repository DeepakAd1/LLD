package tictactoe.strategy;

import tictactoe.model.Board;
import tictactoe.model.PieceType;

public class ColumnWinner implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, int lastRow, int lastCol, PieceType pieceType) {
        int size = board.getSize();
        for (int row = 0; row < size; row++) {
            if (board.getPieceAt(row, lastCol) != pieceType) {
                return false;
            }
        }
        return true;
    }
}
