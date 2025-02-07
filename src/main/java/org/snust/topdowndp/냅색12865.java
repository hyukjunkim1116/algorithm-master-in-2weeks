package org.snust.topdowndp; // package org.snust.topdowndp;

//
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;
//
// public class 냅색12865 {
//
//    private static int[][] arr;
//    private static int[][] dp;
//    private static int n;
//    private static int m;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());
//
//        arr = new int[n][2];
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine()," ");
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            arr[i][0] = a;
//            arr[i][1] = b;
//        }
//
//        dp = new int[n][100010];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 100010; j++) {
//                dp[i][j] = -1;
//            }
//        }
//
//        int ans = recur(0,0);
//        System.out.println(ans);
//    }
//
//    public static int recur(int cur, int w) {
//        if (w > m) return Integer.MIN_VALUE;
//        if (cur == n) return 0;
//        if (dp[cur][w] != -1) return dp[cur][w];
//
//        dp[cur][w] = Math.max(recur(cur+1,w+arr[cur][0])+arr[cur][1],recur(cur+1,w));
//
//        return dp[cur][w];
//    }
// }

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 냅색12865 {

  private static int N;
  private static int M;
  private static int[][] arr;
  private static int[][] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][2];

    for (int i = 0; i < N; i++) {

      st = new StringTokenizer(br.readLine(), " ");
      arr[i][0] = Integer.parseInt(st.nextToken());

      arr[i][1] = Integer.parseInt(st.nextToken());

    }

    dp = new int[N][M+1];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M+1; j++) {
        dp[i][j] = -1;
      }
    }

    int ans = recur(0, 0);
    System.out.println(ans);
  }

  private static int recur(int cur, int w) {

    if (w > M+1) return Integer.MIN_VALUE;
    if (cur == N) return 0;
    if (dp[cur][w] != -1) return dp[cur][w];
    dp[cur][w] = recur(cur+1,w);
    if (w+arr[cur][0] <= M){
      dp[cur][w] = Math.max(dp[cur][w],recur(cur+1,w+arr[cur][0])+arr[cur][1]);
    }
    return dp[cur][w];
  }
}
