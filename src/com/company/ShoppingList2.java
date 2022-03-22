package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingList2 {
  public static void main(String[] args) {

    HashMap<String, Float> prices = new HashMap<>();

    prices.put("Milk", 1.07f);
    prices.put("Rice", 1.59f);
    prices.put("Eggs", 3.14f);
    prices.put("Cheese", 12.60f);
    prices.put("Chicken Breasts", 9.40f);
    prices.put("Apples", 2.31f);
    prices.put("Tomato", 2.58f);
    prices.put("Potato", 1.75f);
    prices.put("Onion", 1.10f);

    HashMap<String, Integer> bobList = new HashMap<>();

    bobList.put("Milk", 3);
    bobList.put("Rice", 2);
    bobList.put("Eggs", 2);
    bobList.put("Cheese", 1);
    bobList.put("Chicken Breasts", 4);
    bobList.put("Apples", 1);
    bobList.put("Tomato", 2);
    bobList.put("Potato", 1);

    HashMap<String, Integer> aliceList = new HashMap<>();

    aliceList.put("Rice", 1);
    aliceList.put("Eggs", 5);
    aliceList.put("Chicken Breasts", 2);
    aliceList.put("Apples", 1);
    aliceList.put("Tomato", 10);


//    Create an application which prints out the answers to the following questions:
//
//    How much does Bob pay?
    System.out.println(howMuchCost(prices, bobList));
//    How much does Alice pay?
    System.out.println(howMuchCost(prices, aliceList));
//    Who buys more Rice?

    System.out.println(whoBuyMore(bobList, aliceList, "Rice"));
//    Who buys more Potato?
    System.out.println(whoBuyMore(bobList, aliceList, "Potato"));
//    Who buys more Ham?
    System.out.println(whoBuyMore(bobList, aliceList, "Ham"));
//    Who buys more Apples?
    System.out.println(whoBuyMore(bobList, aliceList, "Apples"));
//    Who buys more of different products?
    System.out.println(bobList.size() > aliceList.size() ? "Bob" : "Alice");
//    Who buys more items? (more pieces)
    System.out.println(itemsCounter(bobList) > itemsCounter(aliceList) ? "Bob" : "Alice");

  }

  public static float howMuchCost(HashMap listOfPrice, HashMap shoppingList) {
    ArrayList<String> boughtItems = new ArrayList<>();
    boughtItems.addAll(shoppingList.keySet().stream().toList());

    float bill = 0;
    for (int i = 0; i < boughtItems.size(); i++) {
      float price = Float.parseFloat(listOfPrice.get(boughtItems.get(i)).toString());
      int quantity = Integer.parseInt(shoppingList.get(boughtItems.get(i)).toString());
      bill += (price * quantity);
    }
    return bill;
  }

  public static String whoBuyMore(HashMap bob, HashMap alice, String item) {
    String who = "";
    if (bob.containsKey(item) && alice.containsKey(item)) {
      if (Integer.valueOf(bob.get(item).toString()) > Integer.valueOf(alice.get(item).toString())) {
        who = "Bob";
      } else if (Integer.valueOf(bob.get(item).toString()) <
          Integer.valueOf(alice.get(item).toString())) {
        who = "Alice";
      } else {
        who = "no one";
      }
    } else {
      if (bob.containsKey(item)) {
        return "Bob";

      }
      if (alice.containsKey(item)) {
        return "Alice";

      }
      who = "no one";
    }
    return who;

  }

  public static int itemsCounter(HashMap hashMap) {
    ArrayList<Integer> values = new ArrayList<>();
    values.addAll(hashMap.values());

    int count = 0;

    for (int i = 0; i < values.size(); i++) {
      count += values.get(i);
    }
    return count;
  }

}
