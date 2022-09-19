package UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
    private final int[] id;
    private final int[] rank;
    private int cnt;
    public WeightedQuickUnionUF (int n) {
        id = new int[n];
        rank = new int[n];
        cnt = n;
        for (int i = 0; i < n; ++i) {
            id[i] = i;
            rank[i] = 1;
        }
    }
    public int find (int x) {
        while (x != id[x]) {
            x = id[x];
        }
        return x;
    }
    public int count() {
        return cnt;
    }
    public boolean connected (int p, int q) {
        return find(p) == find(q);
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (rank[pRoot] < rank[qRoot]) {
            id[pRoot] = qRoot;
            rank[qRoot] += rank[pRoot];
        } else {
            id[qRoot] = pRoot;
            rank[pRoot] += rank[qRoot];
        }
        cnt--;
    }
    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
