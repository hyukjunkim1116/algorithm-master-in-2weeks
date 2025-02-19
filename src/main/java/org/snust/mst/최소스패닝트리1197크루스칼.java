package org.snust.mst;

import java.io.*;
import java.util.*;

public class 최소스패닝트리1197크루스칼 {
  static int[] parent;
  static int[] rank;

  static class Edge implements Comparable<Edge> {
    int from, to, weight;

    Edge(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return this.weight - o.weight;
    }
  }

  static int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a == b) return;

    if (rank[a] < rank[b]) {
      parent[a] = b;
    } else if (rank[a] > rank[b]) {
      parent[b] = a;
    } else {
      parent[a] = b;
      rank[b]++;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    parent = new int[1000001];
    rank = new int[1000001];

    for (int i = 0; i < 1000001; i++) {
      parent[i] = i;
    }

    Edge[] edges = new Edge[M];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      edges[i] = new Edge(A, B, C);
    }

    Arrays.sort(edges);

    int answer = 0;
    for (Edge edge : edges) {
      if (find(edge.from) != find(edge.to)) {
        union(edge.from, edge.to);
        answer += edge.weight;
      }
    }

    System.out.println(answer);
  }
}
