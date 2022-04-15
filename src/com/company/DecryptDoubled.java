package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DecryptDoubled {
  public static void main(String[] args) {
    // Create a method called decryptDoubled() that takes a filename as string as a parameter
    // and it can decrypt the duplicated-chars.txt file
    // Decryption is the process reversing an encryption, i.e. the process
    // which converts encrypted data into its original form.
    // If the file can't be opened it should return this message: File not found
    // The result should be saved in the output.txt file

    decryptDoubled("src/duplicated-chars.txt");
  }

  public static void decryptDoubled(String fileName) {
    Path filePath = Path.of(fileName);
    Path writeFilePath = Paths.get("output.txt");

    try {
      List<String> cryptedFile = Files.readAllLines(filePath);
      String cleanString = "";
      List<String> decryptedList = new ArrayList<>();
      for (String s : cryptedFile) {
        for (int i = 0; i < s.length(); i++) {
          if (i % 2 != 0) {
            cleanString += s.charAt(i);
          }
        }

        cleanString += " ";

        decryptedList.add(cleanString);
        cleanString = "";
      }

      Files.write(writeFilePath, decryptedList);

    } catch (IOException e) {
      System.out.println("File not found");
    }

  }
}
