package com.squaresgames.Square.games.controller;

import com.squaresgames.Square.games.modele.HeartBeatSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartBeatController {
    @Autowired
    HeartBeatSensor heartbeatSensor;
    @GetMapping("/heartbeat")
   public int getHeartBeat() {
        return heartbeatSensor.get();
    }
}
