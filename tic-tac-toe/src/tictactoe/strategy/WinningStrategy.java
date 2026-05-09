package tictactoe.strategy;

import tictactoe.model.Board;
import tictactoe.model.PieceType;

public interface WinningStrategy {
    boolean checkWinner(Board board, int lastRow, int lastCol, PieceType pieceType);
}
