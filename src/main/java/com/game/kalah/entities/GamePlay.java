package com.game.kalah.entities;

/**
 * Serves as transfer object for a game play.
 */


public class GamePlay {
  
  /**
   * Pit selected by the player.
   */
  private int pitt;
  
  /**
   * Current game state.
   */
  private KalahGame game;

  public GamePlay(int pitt, KalahGame game) {
    this.pitt = pitt;
    this.game = game;
  }

  public int getPitt() {
    return pitt;
  }

  public void setPitt(int pitt) {
    this.pitt = pitt;
  }

  public KalahGame getGame() {
    return game;
  }

  public void setGame(KalahGame game) {
    this.game = game;
  }

}
