package com.game.kalah.service.impl;

import com.game.kalah.constants.GameStatus;
import com.game.kalah.entities.KalahGame;
import com.game.kalah.entities.KalahPlayer;
import com.game.kalah.service.GameService;
import com.game.kalah.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    final int noOfPits = 14;

    final int startingSeeds = 6;

    @Autowired
    private PlayerService playerService;
    /**
     * Initializes Kalah game with start board configuration and status.
     */
    public KalahGame init() {
        KalahGame aGame = new KalahGame();
        int[] board = new int[noOfPits];
        for (int i = 0; i < board.length; i++) {
            if (i == 6 || i == 13) {
                continue;
            }
            board[i] = startingSeeds;
        }
        aGame.setBoard(board);
        aGame.setPlayerA(new KalahPlayer(1, 6));
        aGame.setPlayerB(new KalahPlayer(2, 13));
        aGame.setStatus(GameStatus.PLAYERATURN);
        aGame.setMessage("Welcome to Game of Kalah.");
        return aGame;
    }

    /**
     * Determines and update player turn.
     */
    private void updateNextTurn(KalahGame game) {

        if (game.getStatus().equals(GameStatus.PLAYERATURN)) {
            game.setStatus(GameStatus.PLAYERBTURN);
            return;
        }
        if (game.getStatus().equals(GameStatus.PLAYERBTURN)) {
            game.setStatus(GameStatus.PLAYERATURN);
            return;
        }

    }

    /**
     *
     * Determines if the move is a valid one.
     */
    public boolean isValidMove(int pitt, KalahGame game) {
        if (game.getStatus().equals(GameStatus.PLAYERATURN)) {
            return 0 <= pitt && pitt <= 5;
        } else if (game.getStatus().equals(GameStatus.PLAYERBTURN)) {
            return 7 <= pitt && pitt <= 12;
        }
        return false;
    }

    /**
     * Execute the game as per the player move and update the board position.
     */
    public void play(int pitt, KalahGame game) {
        if (game.getStatus().equals(GameStatus.PLAYERATURN)) {
            play(pitt, game, game.getPlayerA());
        } else if (game.getStatus().equals(GameStatus.PLAYERBTURN)){
            play(pitt, game, game.getPlayerB());
        }
    }

    private void play(int pitt, KalahGame game, KalahPlayer player) {
        int seeds = collectSeeds(pitt, game);
        int lastDroppedPitt = pitt;
        int[] gameBoard = game.getBoard();
        while (seeds > 0) {
            int dropPit = next(lastDroppedPitt);
            if (isKalah(dropPit) && !playerService.isMyKalah(dropPit, player)) {
                lastDroppedPitt = dropPit;
                continue;
            }
            gameBoard[dropPit] += 1;
            seeds -= 1;
            lastDroppedPitt = dropPit;
        }

        if (playerService.isMyPitt(lastDroppedPitt, player) && gameBoard[lastDroppedPitt] == 1) {
            gameBoard[player.getKalahIndex()] += gameBoard[lastDroppedPitt] + gameBoard[12 - lastDroppedPitt];
            gameBoard[lastDroppedPitt] = 0;
            gameBoard[12 - lastDroppedPitt] = 0;
        }

        if (!playerService.isMyKalah(lastDroppedPitt, player))
            updateNextTurn(game);

        checkGameStatus(game);

    }

    /**
     * Determines if game has concluded and winner.
     */
    private void checkGameStatus(KalahGame game) {
        int pitSumSideOne = 0;
        int[] board = game.getBoard();
        for (int i = 0; i < 6; i++) {
            pitSumSideOne += board[i];
        }
        int pitSumSideTwo = 0;
        for (int i = 7; i < 13; i++) {
            pitSumSideTwo += board[i];
        }
        if (pitSumSideOne == 0 || pitSumSideTwo == 0) {
            board[game.getPlayerA().getKalahIndex()] += pitSumSideOne;
            board[game.getPlayerB().getKalahIndex()] += pitSumSideTwo;
            if (board[game.getPlayerA().getKalahIndex()] > board[game.getPlayerB().getKalahIndex()]) {
                game.setStatus(GameStatus.PLAYERAWINS);
            } else {
                game.setStatus(GameStatus.PLAYERBWINS);
            }
            resetBoard(game);
        }
    }

    private void resetBoard(KalahGame game) {
        for (int i = 0; i < noOfPits; i++) {
            if (i != 6 && i != 13)
                game.getBoard()[i] = 0;
        }
    }

    private boolean isKalah(int pitt) {
        return pitt == 6 || pitt == 13;
    }

    private int next(int pitt) {
        pitt += 1;
        return pitt % noOfPits;
    }

    private int collectSeeds(int pitt, KalahGame game) {

        int seeds = game.getBoard()[pitt];
        game.getBoard()[pitt] = 0;
        return seeds;
    }
}
