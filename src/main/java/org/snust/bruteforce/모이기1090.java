package org.snust.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 모이기1090 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());
    // 초기화
    List<List<Integer>> checkerList = new ArrayList<>();
    List<Integer> checkerX = new ArrayList<>();
    List<Integer> checkerY = new ArrayList<>();
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(bufferedReader.readLine(), " ");
      while (st.hasMoreTokens()) {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        checkerX.add(x);
        checkerY.add(y);
        List<Integer> arr = List.of(x, y);
        checkerList.add(arr);
      }
    }
    List<Integer> answers = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      answers.add(-1);
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        List<Integer> dist = new ArrayList<>();
        for (List<Integer> integers : checkerList) {
          int distance =
              // 2차원 생각!!
              Math.abs(checkerX.get(i) - integers.get(0))
                  + Math.abs(checkerY.get(j) - integers.get(1));
          dist.add(distance);
        }
        dist.sort(null);
        int tmp = 0;
        for (int k = 0; k < N; k++) {
          int d = dist.get(k);
          tmp += d;
          if (answers.get(k) == -1) {
            answers.set(k, tmp);
          } else {
            answers.set(k, Math.min(tmp, answers.get(k)));
          }
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      if (i == answers.size() - 1) {
        sb.append(answers.get(i));
      } else {
        sb.append(answers.get(i)).append(" ");
      }
    }
    System.out.println(sb);
  }
}
