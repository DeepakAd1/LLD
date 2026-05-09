package tictactoe.strategy;

import tictactoe.model.Board;
import tictactoe.model.PieceType;

public class DiagonalWinner implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, int lastRow, int lastCol, PieceType pieceType) {
        int size = board.getSize();

        if (lastRow == lastCol && checkMainDiagonal(board, size, pieceType)) {
            return true;
        }

        if (lastRow + lastCol == size - 1 && checkAntiDiagonal(board, size, pieceType)) {
            return true;
        }

        return false;
    }

    private boolean checkMainDiagonal(Board board, int size, PieceType pieceType) {
        for (int i = 0; i < size; i++) {
            if (board.getPieceAt(i, i) != pieceType) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(Board board, int size, PieceType pieceType) {
        for (int i = 0; i < size; i++) {
            if (board.getPieceAt(i, size - 1 - i) != pieceType) {
                return false;
            }
        }
        return true;
    }
}
