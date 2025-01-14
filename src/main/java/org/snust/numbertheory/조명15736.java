package org.snust.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 조명15736 {
  public static void main(String[] args) throws IOException {
    System.out.println(
        (int)
            Math.sqrt(
                Integer.parseInt(
                        new BufferedReader(
                                new InputStreamReader(System.in))
                                .readLine())));
  }
}
