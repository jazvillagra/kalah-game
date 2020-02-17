package com.game.kalah.entities;

import com.game.kalah.constants.GameStatus;

/**
 * Represent a Kalah Game with associated players and status.
 *
 */

public class KalahGame {


  private int[] board;
  private GameStatus status;
  private String message;
  private KalahPlayer playerA;
  private KalahPlayer playerB;


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public GameStatus getStatus() {
    return status;
  }

  public void setStatus(GameStatus status) {
    this.status = status;
  }

  public int[] getBoard() {
    return board;
  }

  public void setBoard(int[] board) {
    this.board = board;
  }

  public KalahPlayer getPlayerA() {
    return playerA;
  }

  public void setPlayerA(KalahPlayer playerA) {
    this.playerA = playerA;
  }

  public KalahPlayer getPlayerB() {
    return playerB;
  }

  public void setPlayerB(KalahPlayer playerB) {
    this.playerB = playerB;
  }

}
