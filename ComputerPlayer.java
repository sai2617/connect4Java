// This class is created for creating the random number for computer player

import java.util.Random;

// Created private variable along with getters and setters with the help of the getmethod() we can call in another class 

public class ComputerPlayer {
  Random comp = new Random();
  private int rand;

  public Random getComp() {
    return comp;
  }

  // public void setComp(Random comp) {
  // this.comp = comp;
  // }

  public int getRand() {
    return rand;
  }

  public void setRand(int rand) {
    this.rand = rand;
  }

  public ComputerPlayer() {
    rand = 1 + comp.nextInt(6);
    System.out.println(rand);
  }
}
