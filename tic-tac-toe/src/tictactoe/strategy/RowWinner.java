package tictactoe.strategy;

import tictactoe.model.Board;
import tictactoe.model.PieceType;

public class RowWinner implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, int lastRow, int lastCol, PieceType pieceType) {
        int size = board.getSize();
        for (int col = 0; col < size; col++) {
            if (board.getPieceAt(lastRow, col) != pieceType) {
                return false;
            }
        }
        return true;
    }
}
