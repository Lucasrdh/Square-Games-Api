package com.squaresgames.Square.games.service;


import com.squaresgames.Square.games.modele.HeartBeatSensor;
import org.springframework.stereotype.Service;

@Service
public class RandomHeartBeat implements HeartBeatSensor {

    @Override
    public int get() {
        return (int) (Math.random() * 100);
    }
}
