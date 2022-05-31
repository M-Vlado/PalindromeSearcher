package com.company.Testing.animal;

public class Animal {

  private int hunger;
  private int thirst;

  public Animal() {
    this.hunger = 50;
    this.thirst = 50;
  }

  public void eat(){
    this.hunger--;
  }

  public void drink(){
    this.thirst--;
  }

  public void play(){
    this.hunger++;
    this.thirst++;
  }

  public int getHunger() {
    return hunger;
  }

  public int getThirst() {
    return thirst;
  }
}
