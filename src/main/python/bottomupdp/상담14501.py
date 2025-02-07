N = int(input())
table = [[] for _ in range(N)]
for i in range(N):
  a, b = map(int, input().split())
  table[i] = [a, b]

dp = [0 for _ in range(N+1)]

for idx in range(N)[::-1]:
  if idx + table[idx][0] > N :
    dp[idx] = dp[idx + 1]
  else :
    dp[idx] = max(dp[idx + table[idx][0]] + table[idx][1], dp[idx + 1])

print(dp[0])
