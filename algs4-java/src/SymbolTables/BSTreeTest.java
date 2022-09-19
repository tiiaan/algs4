package SymbolTables;

public class BSTreeTest {
    private static final int[] arr = {1,5,4,3,2,6};
    public static void main(String[] args) {
        int arrLen = arr.length;
        BSTree<Integer> root = new BSTree<Integer>();
        System.out.print("依次添加: ");
        for (int node : arr) {
            System.out.print(node + " ");
            root.insert(node);
        }

        System.out.print("前序遍历: ");
        root.preOrder();

        System.out.print("中序遍历: ");
        root.inOrder();

        System.out.print("后序遍历: ");
        root.postOrder();

        System.out.println("最小节点值: " + root.min());

        System.out.println("最大节点值: " + root.max());

        System.out.println("删除节点: ");
    }
}
