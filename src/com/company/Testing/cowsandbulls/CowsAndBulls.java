package com.company.Testing.cowsandbulls;

import java.util.Random;
import java.util.Scanner;

public class CowsAndBulls {
  private int guessNumber;
  private boolean isPlaying = true;
  private int counterOfGuess;

  private Scanner scanner;

  public int randomizer(){
    Random random = new Random();
    String randomNo = "";
    for(int i = 0; i<4; i++){
      randomNo = randomNo + random.nextInt(10);
    }
    return Integer.parseInt(randomNo);
  }

  public void game(){
    guessNumber = randomizer();
    scanner = new Scanner(System.in);

    System.out.println("Please enter your guess 4 digit number");
    while (isPlaying){
      try {
        counterOfGuess++;
        String s = scanner.next();
        if(s.length() != 4 || Integer.parseInt(s) > 9999 || Integer.parseInt(s) <0){
          System.out.println("wrong number \nplease enter your guess again.");
        }else {
          System.out.println(evaluateGuess(Integer.parseInt(s)));
          System.out.println("counter of guesses: " + counterOfGuess);
          System.out.println("Please enter your guess 4 digit number");
        }
      }catch (Exception e){
        System.out.println(e.getLocalizedMessage());
      }
    }
    System.out.println("Game over!");
  }

  private String evaluateGuess(int userGuessNumber) {
    String result = "";
    int cow = 0;
    int bull = 0;

    System.out.println("hadam "+guessNumber);
    if(userGuessNumber == guessNumber){
      result = "4 cows";
      isPlaying = false;
    }else {
      char[] guessed = String.valueOf(guessNumber).toCharArray();
      char[] userGuess = String.valueOf(userGuessNumber).toCharArray();
      for(int i=0; i<4; i++){
        for(int j = 0; j<4; j++){
          if(i==j){
            if(String.valueOf(guessed[i]).equals(String.valueOf(userGuess[j]))){
              cow++;
              break;
            }
          }else {
            if(String.valueOf(guessed[i]).equals(String.valueOf(userGuess[j]))){
              bull++;
              break;
            }
          }

        }
      }
      if(cow == 0 && bull == 0){
        result = "";
      }else {
        String cows = cow >1?" cows, ":" cow, ";
        String bulls = bull>1?" bulls.":" bulls";
        result = cow + cows + bull + bulls;
      }
    }
    return result;
  }

}
