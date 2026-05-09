package tictactoe.service;

import tictactoe.model.Game;
import tictactoe.model.GameStatus;
import tictactoe.model.PieceType;
import tictactoe.player.Player;
import tictactoe.strategy.WinningStrategy;

public class GameService {
    private BoardPrinter boardPrinter;

    public GameService() {
        this.boardPrinter = new BoardPrinter();
    }

    public GameStatus startGame(Game game) {
        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            boardPrinter.print(game.getBoard());
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getPieceType() + ")");

            int[] move = currentPlayer.makeMove(game.getBoard());
            int row = move[0], col = move[1];

            if (!game.getBoard().addPiece(row, col, currentPlayer.getPieceType())) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            game.incrementMoves();

            if (isWinner(game, row, col, currentPlayer.getPieceType())) {
                game.setWinner(currentPlayer);
                game.setStatus(GameStatus.PLAYER_WON);
            } else if (game.getTotalMoves() == game.getBoard().getSize() * game.getBoard().getSize()) {
                game.setStatus(GameStatus.DRAW);
            } else {
                game.nextPlayer();
            }
        }

        boardPrinter.print(game.getBoard());
        printResult(game);
        return game.getStatus();
    }

    private boolean isWinner(Game game, int lastRow, int lastCol, PieceType pieceType) {
        for (WinningStrategy strategy : game.getStrategies()) {
            if (strategy.checkWinner(game.getBoard(), lastRow, lastCol, pieceType)) return true;
        }
        return false;
    }

    private void printResult(Game game) {
        if (game.getStatus() == GameStatus.DRAW) {
            System.out.println("It's a draw!");
        } else {
            System.out.println(game.getWinner().getName() + " wins!");
        }
    }
}
