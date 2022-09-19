package SymbolTables;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTree <T extends Comparable<T>> {
    private BSTNode<T> mRoot;
    public class BSTNode<T extends Comparable<T>> {
        T key;
        BSTNode<T> left;
        BSTNode<T> right;
        BSTNode<T> parent;
        public BSTNode(T key, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    public BSTree() {
        mRoot = null;
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    private void preOrder(BSTNode<T> root) {
        if (root == null) return;
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    private void inOrder(BSTNode<T> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    private void postOrder(BSTNode<T> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.key + " ");
    }

    public void bfs() {
        bfs(mRoot);
    }

    private void bfs(BSTNode<T> root) {
        if (root == null) return;
        Deque<BSTNode<T>> queue = new ArrayDeque<BSTNode<T>>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print("[");
            while (len > 0) {
                BSTNode<T> node = queue.poll();
                System.out.print(node.key + " ");
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                len--;
            }
            System.out.print("] ");
        }
    }

    public BSTNode<T> search(T key) {
        return search(mRoot, key);
    }

    private BSTNode<T> search(BSTNode<T> root, T key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            search(root.left, key);
        } else if (cmp > 0) {
            search(root.right, key);
        } else {
            return root;
        }
    }

    public BSTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    private BSTNode<T> iterativeSearch(BSTNode<T> root, T key) {
        while (root != null) {
            int cmp = key.compareTo(root.key);
            if (cmp < 0) root = root.left;
            else if (cmp > 0) root = root.right;
            else return root;
        }
        return null;
    }

    public T min() {
        BSTNode<T> minNode = min(mRoot);
        if (minNode != null) return minNode.key;
        return null;
    }

    private BSTNode<T> min(BSTNode<T> root) {
        if (root == null) return null;
        while (root.left != null) root = root.left;
        return root;
    }

    public T max() {
        BSTNode<T> maxNode = max(mRoot);
        if (maxNode != null) return maxNode.key;
        return null;
    }

    private BSTNode<T> max(BSTNode<T> root) {
        if (root == null) return null;
        while (root.right != null) root = root.right;
        return root;
    }

    public BSTNode<T> predecessor(BSTNode<T> p) {
        if (search(p.key) == null) return null;
        if (p.left != null) {
            return max(p.left);
        }
        BSTNode<T> prev = p.parent;
        while (prev != null && p = prev.left) {
            p = prev;
            prev = p.parent;
        }
        return prev;
    }

    public BSTNode<T> successor(BSTNode<T> p) {
        if (search(p.key) == null) return null;
        if (p.right != null) {
            return min(p.right);
        }
        BSTNode<T> prev = p.parent;
        while (prev != null && p == prev.right) {
            p = prev;
            prev = p.parent;
        }
        return prev;
    }

    public void insert(T key) {}
}
