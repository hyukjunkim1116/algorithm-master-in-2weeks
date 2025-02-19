package org.snust.tree;

import java.io.*;
import java.util.*;

public class 트리순회1991 {
static int[][] tree;
static StringBuilder sb = new StringBuilder();

static void preOrder(int start) {
if (start != -18) {
sb.append((char)(start + 64));
preOrder(tree[start][0]);
preOrder(tree[start][1]);
}
}

static void inOrder(int start) {
if (start != -18) {
inOrder(tree[start][0]);
sb.append((char)(start + 64));
inOrder(tree[start][1]);
}
}

static void postOrder(int start) {
if (start != -18) {
postOrder(tree[start][0]);
postOrder(tree[start][1]);
sb.append((char)(start + 64));
}
}

public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

int n = Integer.parseInt(br.readLine());
tree = new int[n + 1][2];

for (int i = 0; i < n; i++) {
StringTokenizer st = new StringTokenizer(br.readLine());
int a = st.nextToken().charAt(0) - 64;
int b = st.nextToken().charAt(0) - 64;
int c = st.nextToken().charAt(0) - 64;

tree[a][0] = b;
tree[a][1] = c;
}

preOrder(1);
sb.append("\n");
inOrder(1);
sb.append("\n");
postOrder(1);

System.out.println(sb.toString());
}
}
