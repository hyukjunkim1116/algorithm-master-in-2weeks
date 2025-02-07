package org.snust.bottomupdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB색칠하기1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[2][3];

        // Initialize first row
        for (int k = 0; k < 3; k++) {
            dp[0][k] = graph[0][k];
        }

        // Fill dp table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[1][j] = Math.min(dp[0][1] + graph[i][j], dp[0][2] + graph[i][j]);
                }
                if (j == 1) {
                    dp[1][j] = Math.min(dp[0][0] + graph[i][j], dp[0][2] + graph[i][j]);
                }
                if (j == 2) {
                    dp[1][j] = Math.min(dp[0][0] + graph[i][j], dp[0][1] + graph[i][j]);
                }
            }

            // Copy row 1 to row 0
            for (int f = 0; f < 3; f++) {
                dp[0][f] = dp[1][f];
            }
        }

        // Find minimum in last row
        int result = Math.min(Math.min(dp[1][0], dp[1][1]), dp[1][2]);
        System.out.println(result);
    }
}