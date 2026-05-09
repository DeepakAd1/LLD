package tictactoe.player;

import tictactoe.model.Board;
import tictactoe.model.PieceType;

public interface Player {
    String getName();
    PieceType getPieceType();
    int[] makeMove(Board board);
}
