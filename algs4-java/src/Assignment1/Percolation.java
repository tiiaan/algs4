package Assignment1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int n;
    private final boolean[] state;
    private int openSitesCount;
    private final WeightedQuickUnionUF ufAct, ufVir;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.n = n;
        if (n <= 0) {
            throw new IllegalArgumentException("n <= 0");
        }
        int sitesCount = n * n;
        ufAct = new WeightedQuickUnionUF(sitesCount + 1);
        ufVir = new WeightedQuickUnionUF(sitesCount + 2);
        state = new boolean[sitesCount + 2];
        for (int i = 0; i < sitesCount + 2; ++i) {
            if (i == sitesCount || i == sitesCount + 1) {
                state[i] = true;
            } else {
                state[i] = false;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || row > n - 1|| col < 0 || col > n - 1) {
            throw new IllegalArgumentException("Out Of Bound.");
        }
        int cur = row * n + col;
        state[cur] = true;
        if (row == 0) {
            ufAct.union(cur, n * n);
            ufVir.union(cur, n * n);
        }
        if (row == n - 1) {
            ufVir.union(cur, n * n + 1);
        }
        if (row > 0 && isOpen(row - 1, col)) {
            ufAct.union(cur, cur - n);
            ufVir.union(cur, cur - n);
        }
        if (row < n - 1 && isOpen(row + 1, col)) {
            ufAct.union(cur, cur + n);
            ufVir.union(cur, cur + n);
        }
        if (col > 0 && isOpen(row, col - 1)) {
            ufAct.union(cur, cur - 1);
            ufVir.union(cur, cur - 1);
        }
        if (col < n - 1 && isOpen(row, col + 1)) {
            ufAct.union(cur, cur + 1);
            ufVir.union(cur, cur + 1);
        }
        openSitesCount ++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 0 || row > n - 1|| col < 0 || col > n - 1) {
            throw new IllegalArgumentException("Out Of Bound.");
        }
        return state[row * n + col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 0 || row > n - 1|| col < 0 || col > n - 1) {
            throw new IllegalArgumentException("Out Of Bound.");
        }
        return ufAct.find(n * n) == ufAct.find(row * n + col);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSitesCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return ufVir.find(n * n) == ufVir.find(n * n + 1);
    }

    // test client (optional)
//    public static void main(String[] args)
 }
