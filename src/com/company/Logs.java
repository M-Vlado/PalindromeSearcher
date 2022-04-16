package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logs {
  public static void main(String[] args) {

    // Read all data from 'log.txt'
    // Each line represents a log message from a web server
    // Write a function that returns an array with the unique IP adresses
    // Write a function that returns the GET / POST request ratio

    String fileName = "log.txt";

    System.out.println(Arrays.toString(uniqueIP(fileName)));

    System.out.println(ratioGetPost(fileName));


  }

  public static String[] uniqueIP(String fileName) {
    String[] uIP;

    HashMap<String, Integer> addresses = new HashMap<>();

    try {
      InputStream inputStream = Logs.class.getClassLoader().getResourceAsStream(fileName);
      assert inputStream != null;
      BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

      String line;
      while ((line = br.readLine()) != null) {

        Pattern p = Pattern.compile("([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})");

        Matcher m = p.matcher(line);
        if (m.find()) {
          addresses.put(m.group(0), 1);
        }

      }

      br.close();

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    List<String> ipAddresses = new ArrayList<>();
    uIP = new String[addresses.size()];
    for (Map.Entry<String, Integer> entry : addresses.entrySet()) {
      ipAddresses.add(entry.getKey());
    }

    return ipAddresses.toArray(uIP);

  }

  public static String ratioGetPost(String fileName) {

    int post = 0;
    int get = 0;

    try {
      InputStream inputStream = Logs.class.getClassLoader().getResourceAsStream(fileName);
      assert inputStream != null;
      BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

      String line;
      while ((line = br.readLine()) != null) {

        Pattern pPost = Pattern.compile("POST");
        Pattern pGet = Pattern.compile("GET");

        Matcher mPost = pPost.matcher(line);
        Matcher mGet = pGet.matcher(line);

        if (mPost.find()) {
          post++;
        }
        if (mGet.find()) {
          get++;
        }

      }

      br.close();

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    return "POST/GET ratio is: ".concat(
        String.valueOf(post).concat("/").concat(String.valueOf(get)));
  }
}
