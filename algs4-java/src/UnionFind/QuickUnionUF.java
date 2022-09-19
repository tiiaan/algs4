package UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {
    private final int[] id;
    private int cnt;
    public QuickUnionUF (int n) {
        cnt = n;
        id = new int[n];
        for (int i = 0; i < n; ++i) {
            id[i] = i;
        }
    }
    public int find (int x) {
        while (x != id[x]) {
            x = id[x];
        }
        return x;
    }
    public boolean connected (int p, int q) {
        return find(p) == find(q);
    }
    public void union (int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        cnt --;
    }
    public int count() {
        return cnt;
    }
    public static void main (String[] args) {
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
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