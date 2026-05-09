package tictactoe.model;

public class Board {
    private int size;
    private PieceType[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PieceType[size][size];
    }

    public boolean addPiece(int row, int column, PieceType pieceType) {
        if (row < size && column < size && board[row][column] == null) {
            board[row][column] = pieceType;
            return true;
        }
        return false;
    }

    public PieceType getPieceAt(int row, int col) {
        return board[row][col];
    }

    public int getSize() {
        return size;
    }

}
