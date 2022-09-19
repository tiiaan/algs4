package SymbolTables;

public class BST <Key extends Comparable<Key>, Value> {
    private TreeNode root;
    private class TreeNode {
        private Key key;
        private Value val;
        private TreeNode left, right;
        private int N;
        public TreeNode() {}
        public TreeNode(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
        public TreeNode(Key key, Value val, TreeNode left, TreeNode right, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.left = left;
            this.right = right;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(TreeNode root) {
        if (root == null) return 0;
        else return root.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(TreeNode root, Key key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp < 0) return get(root.left, key);
        else if (cmp > 0) return get(root.right, key);
        else return root.val;
    }

    public Value iterativeGet(Key key) {
        return iterativeGet(root, key);
    }

    private Value iterativeGet(TreeNode root, Key key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp < 0) root = root.left;
        else if (cmp > 0) root = root.right;
        else return root.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private TreeNode put(TreeNode root, Key key, Value val) {
        if (root == null) return new TreeNode(key, val, 1);
        int cmp = key.compareTo(root.key);
        if (cmp < 0) root.left = put(root.left, key, val);
        else if (cmp > 0) root.right = put(root.right, key, val);
        else root.val = val; //key已经存在则更新它的值
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }
}
