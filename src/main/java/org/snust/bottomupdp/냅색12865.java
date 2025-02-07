package org.snust.bottomupdp;

import java.io.*;
import java.util.*;

public class 냅색12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][k + 1];

        for (int y = 1; y <= n; y++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for (int x = 1; x <= k; x++) {
                if (x < weight) {
                    dp[y][x] = dp[y-1][x];
                } else {
                    dp[y][x] = Math.max(dp[y-1][x], dp[y-1][x-weight] + value);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}

