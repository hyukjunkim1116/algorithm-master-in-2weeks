package org.snust.bottomupdp;

import java.io.*;
import java.util.*;

public class 상담14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for (int idx = N - 1; idx >= 0; idx--) {
            if (idx + table[idx][0] > N) {
                dp[idx] = dp[idx + 1];
            } else {
                dp[idx] = Math.max(dp[idx + table[idx][0]] + table[idx][1], dp[idx + 1]);
            }
        }

        System.out.println(dp[0]);
    }
}
