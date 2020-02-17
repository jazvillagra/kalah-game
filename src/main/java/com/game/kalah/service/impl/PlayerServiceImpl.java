package com.game.kalah.service.impl;

import com.game.kalah.entities.KalahPlayer;
import com.game.kalah.service.PlayerService;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    /**
     * Determines if the Kalah belongs to player.
     */
    public boolean isMyKalah(int pitt, KalahPlayer player) {
        return player.getKalahIndex() == pitt;
    }

    /**
     * Determines if the pit belongs to player.
     */
    public boolean isMyPitt(int pitt, KalahPlayer player) {
        if (player.getId() == 1)
            return 0 <= pitt && pitt <= 5;
        else
            return 7 <= pitt && pitt <= 12;
    }
}
