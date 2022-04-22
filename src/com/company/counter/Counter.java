package com.company.counter;

public class Counter {

  private int counter;
  private int initValue;

  public Counter() {
    this.initValue = 0;
  }

  public Counter(int counter) {
    this.counter = counter;
    this.initValue = counter;

  }

  public void add(int value){
    this.counter += value;
  }

  public void add(){
    this.counter++;
  }

  public int get() {
    return counter;
  }

  public void reset(){
    this.counter = initValue;
  }
}
