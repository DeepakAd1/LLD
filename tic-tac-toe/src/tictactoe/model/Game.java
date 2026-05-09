package tictactoe.model;

import tictactoe.player.Player;
import tictactoe.strategy.WinningStrategy;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<WinningStrategy> strategies;
    private int currentPlayerIndex;
    private int totalMoves;
    private GameStatus status;
    private Player winner;

    public Game(int boardSize, List<Player> players, List<WinningStrategy> strategies) {
        this.board = new Board(boardSize);
        this.players = players;
        this.strategies = strategies;
        this.currentPlayerIndex = 0;
        this.totalMoves = 0;
        this.status = GameStatus.IN_PROGRESS;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void incrementMoves() { totalMoves++; }

    public Board getBoard() { return board; }
    public List<WinningStrategy> getStrategies() { return strategies; }
    public int getTotalMoves() { return totalMoves; }
    public GameStatus getStatus() { return status; }
    public void setStatus(GameStatus status) { this.status = status; }
    public Player getWinner() { return winner; }
    public void setWinner(Player winner) { this.winner = winner; }
}
