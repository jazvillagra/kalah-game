package com.game.kalah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This is a Spring configuration application starter class created by Spring
 * boot initializer.
 *
 */
//This is only used because IntelliJ keeps complaining with no reason. See https://stackoverflow.com/a/31891805/6068073
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class KalahGameApplication {

  public static void main(String[] args) {
    SpringApplication.run(KalahGameApplication.class, args);
  }
}
