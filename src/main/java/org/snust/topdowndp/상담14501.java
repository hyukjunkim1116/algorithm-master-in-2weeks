package org.snust.topdowndp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상담14501 {

  private static int N;
  private static int[] dp;
  private static int[][] table;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    table = new int[N + 1][2];

    StringTokenizer st;

    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      table[i + 1][0] = a;
      table[i + 1][1] = b;
    }
    dp = new int[N + 1];
    for (int i = 0; i < N + 1; i++) {
      dp[i] = -1;
    }

    int ans = sol(1);
    System.out.println(ans);
  }

  public static int sol(int idx) {
    if (idx > N + 1) return Integer.MIN_VALUE;
    if (idx == N + 1) return 0;
    if (dp[idx] != -1) return dp[idx];

    dp[idx] = Math.max(sol(idx + 1), sol(idx + table[idx][0]) + table[idx][1]);
    return dp[idx];
  }
}
