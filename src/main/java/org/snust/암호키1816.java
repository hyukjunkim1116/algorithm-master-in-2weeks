package org.snust;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호키1816 {
  public static void main(String[] args) throws IOException {
    //    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //    String stringInput = br.readLine();
    //    String[] strings = br.readLine().split(" ");
    //    StringTokenizer st = new StringTokenizer(br.readLine());
    //    String A = st.nextToken();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      long tc = Long.parseLong(br.readLine());
      for (int j = 2; j <= 1_000_001; j++) {
        if (tc % j == 0) {
          System.out.println("NO");
          break;
        }
        if (j == 1_000_001) {
          System.out.println("YES");
        }
      }
    }
  }
}
