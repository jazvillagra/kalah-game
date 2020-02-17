package com.game.kalah.controllers;

import com.game.kalah.entities.GamePlay;
import com.game.kalah.entities.KalahGame;
import com.game.kalah.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This class exposes RESTFul end-points which are used to by client to
 * communicate with controllers.
 *
 */
@RestController
@RequestMapping("/kalah")
public class GameController {

  @Autowired
  GameService gameService;

  /**
   * This controllers end-point initialize and starts a new Game.
   * 
   * @return KalahGame object with each pit populated with 6-Stones is returned.
   * 
   */
  @GetMapping("/start")
  public KalahGame startKalah() {
    return gameService.init();

  }

  /**
   * This controllers end-point makes a play of the game and change the game state
   * according the selected pit by a player.
   * 
   * @return Updated KalahGame object from the move made a player.
   */
  @PostMapping(value = "/play", consumes = "application/json")
  public KalahGame play(@RequestBody GamePlay aPlay) {
    KalahGame game = aPlay.getGame();

    int pitt = aPlay.getPitt();
    if (gameService.isValidMove(pitt, game)) {
      gameService.play(pitt, aPlay.getGame());
    } else {
      game.setMessage("Wrong move!!!");
    }
    return game;
  }

}
