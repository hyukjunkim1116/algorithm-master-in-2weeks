package org.snust.twopointer;

import java.io.*;
import java.util.*;

public class 이벤트22988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        long[] arr = new long[(int) N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int s = 0;
        long e = N - 1;
        int remain = 0;
        int cnt = 0;

        while(s <= e) {
            if(arr[(int) e] == X) {
                cnt++;
                e--;
                continue;
            }

            if(s == e) {
                remain++;
                break;
            }

            if(arr[(int) e] + arr[s] >= (X + 1) / 2) {
                cnt++;
                s++;
                e--;
            } else {
                s++;
                remain++;
            }
        }

        System.out.println(cnt + remain / 3);
    }
}
