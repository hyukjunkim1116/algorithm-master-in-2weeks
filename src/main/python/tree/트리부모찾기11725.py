import sys
sys.setrecursionlimit(99999)

def dfs(node,prv):
  # parent[node] = prv
  # child[prv].append(node)

  for nxt in relation[node]:
    if nxt == prv:
      continue

    # 부모 자식 관계
    # child[node].append(nxt)
    parent[nxt] = node

    # 깊이
    # depth[nxt] = depth[node] + 1

    # 자식에게 이동 -- ↑
    dfs(nxt,node)
    # 부모에게 이동 -- ↓

    # 자식들의 숫자
    # child_num[node] += child_num[nxt]

n = int(input())
relation = [[] for _ in range(n+1)]
parent = [0 for _ in range(n+1)]
child = [[] for _ in range(n+1)]
depth = [0 for _ in range(n+1)]
child_num = [1 for _ in range(n+1)]

# 입력
for i in range(n-1):
  a, b = map(int,input().split())
  relation[a].append(b)
  relation[b].append(a)

# 출력
dfs(1, 0)

for answer in parent[2:]:
  print(answer)
