package tictactoe.service;

import tictactoe.model.Board;

public class BoardPrinter {
    public void print(Board board) {
        int size = board.getSize();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(board.getPieceAt(row, col) == null ? "." : board.getPieceAt(row, col));
                if (col < size - 1) System.out.print(" | ");
            }
            System.out.println();
            if (row < size - 1) System.out.println("-".repeat(size * 4 - 3));
        }
        System.out.println();
    }
}
