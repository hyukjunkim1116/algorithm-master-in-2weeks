N = int(input())

input_list = [list(map(int, input().split())) for _ in range(N)]
answer = 0
def recur(t,p):
  global answer
  if t > N-1:
    if t > N:return
    answer = max(answer,p)
    return

  recur(t+input_list[t][0],p+input_list[t][1])
  recur(t+1,p)

recur(0,0)
print(answer)