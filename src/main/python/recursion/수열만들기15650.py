# 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
#
# 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
# 고른 수열은 오름차순이어야 한다.
def recur(start, depth):
  if depth == M:  # 수열의 길이가 M이 되면
    print(*arr)  # 현재 수열 출력
    return

  for i in range(start, N + 1):  # start부터 N까지 순회
    arr.append(i)  # 현재 숫자 추가
    recur(i + 1, depth + 1)  # 다음 숫자는 현재보다 큰 수부터 시작
    arr.pop()  # 백트래킹

N, M = map(int, input().split())
arr = []
recur(1, 0)

# 4 2 입력 시 작동방식을 단계별로 설명드립니다:
#
# 1단계: recur(1, 0) 호출
#
# start=1, depth=0
# arr=[]
# i=1: arr=[1] → recur(2, 1) 호출
# i=2: arr=[2] → recur(3, 1) 호출
# i=3: arr=[3] → recur(4, 1) 호출
# i=4: arr=[4] → recur(5, 1) 호출
# 2단계: recur(2, 1) (arr=[1])
#
# start=2, depth=1
# i=2: arr=[1,2] → depth==M이므로 "1 2" 출력 → pop으로 2제거
# i=3: arr=[1,3] → depth==M이므로 "1 3" 출력 → pop으로 3제거
# i=4: arr=[1,4] → depth==M이므로 "1 4" 출력 → pop으로 4제거
# 1 pop으로 제거
# 3단계: recur(3, 1) (arr=[2])
#
# start=3, depth=1
# i=3: arr=[2,3] → depth==M이므로 "2 3" 출력 → pop으로 3제거
# i=4: arr=[2,4] → depth==M이므로 "2 4" 출력 → pop으로 4제거
# 2 pop으로 제거
# 4단계: recur(4, 1) (arr=[3])
#
# start=4, depth=1
# i=4: arr=[3,4] → depth==M이므로 "3 4" 출력 → pop으로 4제거
# 3 pop으로 제거
# 최종 출력: 1 2 1 3 1 4 2 3 2 4 3 4
#
# 이렇게 오름차순으로 모든 가능한 2개 조합이 출력됩니다.