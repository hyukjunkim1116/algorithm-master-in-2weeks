package org.snust.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숨어있는숫자찾기2247 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long N = Long.parseLong(br.readLine());

    long tmpA = 0;
    for (int i = 2; i < N / 2 + 1; i++) {
      tmpA += (long) (i * (Math.floor((double) N / i) - 1) % 1_000_000);
    }
    System.out.println(tmpA%1_000_000);
  }
}
//N=12일 때를 예시로 설명하겠습니다.
//
//i=2일 때:
//
//        2는 2,4,6,8,10,12의 약수
//Math.floor(12/2) = 6
//        2 * (6-1) = 10
//i=3일 때:
//
//        3은 3,6,9,12의 약수
//Math.floor(12/3) = 4
//        3 * (4-1) = 9
//i=4일 때:
//
//        4는 4,8,12의 약수
//Math.floor(12/4) = 3
//        4 * (3-1) = 8
//i=5일 때:
//
//        5는 10의 약수
//Math.floor(12/5) = 2
//        5 * (2-1) = 5
//i=6일 때:
//
//        6은 6,12의 약수
//Math.floor(12/6) = 2
//        6 * (2-1) = 6
//따라서 CSOD(12) = 10 + 9 + 8 + 5 + 6 = 38
//
//이렇게 각 숫자마다 실질적 약수들의 합을 효율적으로 계산할 수 있습니다.
//N=12일 때 1을 빼는 이유를 설명하겠습니다.
//
//i=2인 경우를 보면:
//
//        2가 약수인 수들: 2,4,6,8,10,12
//        Math.floor(12/2) = 6 이건 2가 약수로 들어가는 횟수
//여기서 1을 빼서 (6-1)=5를 곱하는 이유는
//2 * 5 = 10이 되어서
//2,4,6,8,10 까지만 계산됨 (12는 제외)
//왜냐하면 12는 자기자신이라 실질적 약수 계산에서 제외해야 하기 때문
//i=3인 경우도:
//
//        3이 약수인 수들: 3,6,9,12
//        Math.floor(12/3) = 4
//여기서 1을 빼서 (4-1)=3을 곱하면
//3 * 3 = 9가 되어서
//3,6,9 까지만 계산됨 (12는 제외)
//이런 식으로 각 i마다 자기자신(N)을 약수 계산에서 제외하기 위해 1을 빼는 것입니다.