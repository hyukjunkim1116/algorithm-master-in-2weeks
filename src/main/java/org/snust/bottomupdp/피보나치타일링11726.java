package org.snust.bottomupdp;

import java.io.*;

public class 피보나치타일링11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n];

        for (int idx = 0; idx < n; idx++) {
            if (idx < 3) {
                dp[idx] = idx + 1;
            } else {
                dp[idx] = (dp[idx-1] + dp[idx-2]) % 10007;
            }
        }

        System.out.println(dp[n-1]);
    }
}