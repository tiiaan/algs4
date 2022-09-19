package UnionFind;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF {
    private final int[] id;
    private int cnt;
    public QuickFindUF (int n) {
        id = new int[n];
        cnt = n;
        for (int i = 0; i < n; ++i) {
            id[i] = i;
        }
    }

    public int find (int x) {
        return id[x];
    }

    public boolean connected (int p, int q) {
        return id[p] == id[q];
    }

    public void union (int p, int q) {
        int pID = id[p];
        int qID = id[q];
        for (int i = 0; i < id.length; ++i) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        cnt --;
    }

    public int count() {
        return cnt;
    }

    public static void main (String[] args) {
        int n = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(n);
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

/*
javac-algs4 -d . QuickFindUF.java
java-algs4 UnionFind.QuickFindUF < /Users/tiiaan/Learning/algs4/data/tinyUF.txt
*/