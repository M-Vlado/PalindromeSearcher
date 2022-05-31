package com.company.Testing.sum;

import java.util.ArrayList;

public class Summing {

  public Integer sum(ArrayList<Integer> input){
    int result = 0;
    if(input == null){
      return 0;
    }
    for(Integer i: input){
      result += i;
    }
    return result;
  }
}
