import sys
sys.setrecursionlimit(99999999)

input = sys.stdin.readline

def sol(idx):

  if idx > N+1:
    return -9999999999999
  if idx == N+1:
    return 0

  if dp[idx] != -1:
    return dp[idx]

  dp[idx] = max(sol(idx+1), sol(idx+table[idx][0]) + table[idx][1])
  return dp[idx]


N = int(input())
table = [[] for _ in range(N+1)]
for i in range(N):
  a, b = map(int, input().split())
  table[i+1] = [a, b]
dp = [-1 for _ in range(N+1)]

ans = sol(1)
print(ans)
