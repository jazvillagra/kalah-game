package com.game.kalah.entities;

/**
 * Represents the player of a Kalah Game.
 *
 */

public class KalahPlayer {


  private int id;
  private int kalahIndex;

  public KalahPlayer(int id, int kalahIndex) {
    this.id = id;
    this.kalahIndex = kalahIndex;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getKalahIndex() {
    return kalahIndex;
  }

  public void setKalahIndex(int kalahIndex) {
    this.kalahIndex = kalahIndex;
  }

}
