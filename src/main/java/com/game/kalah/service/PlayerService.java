package com.game.kalah.service;

import com.game.kalah.entities.KalahPlayer;


public interface PlayerService {

    boolean isMyKalah(int pitt, KalahPlayer player);

    boolean isMyPitt(int pitt,  KalahPlayer player);
}
