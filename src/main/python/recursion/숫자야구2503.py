import sys

sys.setrecursionlimit(99999)

def checker(hint_idx,number):
  hint_number = hint_list[hint_idx][0]
  hint_strike = hint_list[hint_idx][1]
  hint_ball = hint_list[hint_idx][2]
  hint_number_100 = hint_number // 100
  hint_number_10 = (hint_number % 100) // 10
  hint_number_1 = hint_number % 10
  input_number_100 = number // 100
  input_number_10 = (number % 100) // 10
  input_number_1 = number % 10
  strike_count = 0
  ball_count = 0

  if (input_number_100 == input_number_10 or
      input_number_10 == input_number_1 or
      input_number_1 == input_number_100):
    return  False

  if (input_number_100 == 0 or
      input_number_10 == 0 or
      input_number_1 == 0):
    return  False

  if input_number_100 == hint_number_100: strike_count += 1
  if input_number_10 == hint_number_10: strike_count += 1
  if input_number_1 == hint_number_1: strike_count += 1

  if (input_number_100 == hint_number_10 or
      input_number_100 == hint_number_1): ball_count += 1

  if (input_number_10 == hint_number_100 or
      input_number_10 == hint_number_1): ball_count += 1
  if (input_number_1 == hint_number_10 or
      input_number_1 == hint_number_100): ball_count += 1

  if (strike_count == hint_strike and
      ball_count == hint_ball):
    return True
  else:
    return  False

def recur(hint_idx, number):
  global answer

  if number == 1000:
    return

  if hint_idx == N:
    answer += 1
    recur(0, number + 1)
    return

  if checker(hint_idx, number):
    recur(hint_idx+1,number)
  else:
    recur(0,number+1)




N = int(input())

hint_list = [list(map(int, input().split())) for _ in range(N)]

answer = 0

recur(0, 100)

print(answer)
