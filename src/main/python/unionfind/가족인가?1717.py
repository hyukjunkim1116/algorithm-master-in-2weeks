import sys
sys.setrecursionlimit(100000)

def _find(A):
  if par[A] == A:
    return A
  par[A] = _find(par[A])  # Path compression
  return par[A]

def _union(A, B):
  A = _find(A)
  B = _find(B)

  if A == B:
    return

  if rank[A] < rank[B]:
    par[A] = B
  elif rank[A] > rank[B]:
    par[B] = A
  else:
    par[B] = A
    rank[A] += 1

N, M = map(int, input().split())

rank = [0] * (N+1)
par = [i for i in range(N+1)]

for _ in range(M):
  X, A, B = map(int, input().split())

  if X == 0:
    _union(A, B)
  else:
    print("YES" if _find(A) == _find(B) else "NO")
