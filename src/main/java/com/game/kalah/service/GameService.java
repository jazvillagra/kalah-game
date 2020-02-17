package com.game.kalah.service;

import com.game.kalah.entities.KalahGame;

public interface GameService {

    KalahGame init();

    boolean isValidMove(int pitt, KalahGame game);

    void play(int pitt, KalahGame game);
}
