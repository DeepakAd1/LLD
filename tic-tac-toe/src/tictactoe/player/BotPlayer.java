package tictactoe.player;

import tictactoe.model.Board;
import tictactoe.model.PieceType;

import java.util.Random;

public class BotPlayer implements Player {
    private String name;
    private PieceType pieceType;
    private Random random;

    public BotPlayer(String name, PieceType pieceType) {
        this.name = name;
        this.pieceType = pieceType;
        this.random = new Random();
    }

    @Override
    public String getName() { return name; }

    @Override
    public PieceType getPieceType() { return pieceType; }

    @Override
    public int[] makeMove(Board board) {
        int size = board.getSize();
        int row, col;
        do {
            row = random.nextInt(size);
            col = random.nextInt(size);
        } while (board.getPieceAt(row, col) != null);
        System.out.println(name + " (Bot) plays at (" + row + ", " + col + ")");
        return new int[]{row, col};
    }
}
