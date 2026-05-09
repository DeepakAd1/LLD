package tictactoe.player;

import tictactoe.model.Board;
import tictactoe.model.PieceType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private String name;
    private PieceType pieceType;
    private Scanner scanner;

    public HumanPlayer(String name, PieceType pieceType) {
        this.name = name;
        this.pieceType = pieceType;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getName() { return name; }

    @Override
    public PieceType getPieceType() { return pieceType; }

    @Override
    public int[] makeMove(Board board) {
        while (true) {
            try {
                System.out.print("Enter row and column (0-indexed): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                return new int[]{row, col};
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter two numbers.");
            }
        }
    }
}
