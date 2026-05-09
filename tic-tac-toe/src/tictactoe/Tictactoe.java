package tictactoe;

import tictactoe.model.Game;
import tictactoe.model.PieceType;
import tictactoe.player.BotPlayer;
import tictactoe.player.HumanPlayer;
import tictactoe.player.Player;
import tictactoe.service.GameService;
import tictactoe.strategy.ColumnWinner;
import tictactoe.strategy.DiagonalWinner;
import tictactoe.strategy.RowWinner;
import tictactoe.strategy.WinningStrategy;

import java.util.Arrays;
import java.util.List;

public class Tictactoe {
    public static void main(String[] args) {
        List<Player> players = Arrays.asList(
                new HumanPlayer("Alice", PieceType.X),
                new BotPlayer("Bot", PieceType.O)
        );

        List<WinningStrategy> strategies = Arrays.asList(
                new RowWinner(),
                new ColumnWinner(),
                new DiagonalWinner()
        );

        Game game = new Game(3, players, strategies);
        GameService gameService = new GameService();
        gameService.startGame(game);
    }
}
