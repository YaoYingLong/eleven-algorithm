package algorithm.cm.tree;

import java.util.Arrays;

public class RedBlackTree {
    private final int Red = 0; // 红色
    private final int Black = 1; // 黑色
    private class Node {
        int key = -1;       // 数据
        int color = Black;  // 颜色
        Node left = nil;    // nil表示的是叶子结点
        Node right = nil;   // 右节点
        Node parent = nil;  // 父节点
        Node(int key) {
            this.key = key;
        }
        @Override
        public String toString() {
            return "Node [key=" + key + ", color=" + color + ", left=" + left.key + ", right=" + right.key + ", p=" + parent.key + "]" + "\r\n";
        }
    }

    private final Node nil = new Node(-1);
    private Node root = nil;

    public void printTree(Node node) {
        if (node == nil) {
            return;
        }
        printTree(node.left);
        System.out.print(node.toString());
        printTree(node.right);
    }

    /**
     * 向红黑树插入节点
     */
    private void insert(Node node) {
        Node temp = root;
        if (root == nil) { // 若为根节点
            root = node;
            node.color = Black; // 将根节点设置为黑色
            node.parent = nil;  // 根节点父节点为null
        } else { // 不是根节点
            node.color = Red; // 将节点颜色设置为红色
            while (true) { // 完成节点插入
                if (node.key < temp.key) { // 插入节点位于左边
                    if (temp.left == nil) {
                        temp.left = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else { // 插入节点位于右边
                    if (temp.right == nil) {
                        temp.right = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
            fixTree(node); // 平衡红黑树
        }
    }

    private void fixTree(Node node) {
        while (node.parent.color == Red) { // 若父节点为红色
            Node uncleNode = nil; // 当前节点的叔叔节点
            if (node.parent == node.parent.parent.left) { // 若插入节点的父节点为祖父节点的左节点
                uncleNode = node.parent.parent.right;
                if (uncleNode != nil && uncleNode.color == Red) { // 若叔叔节点存在且也为红色
                    node.parent.color = Black;  // 将父节点置为黑色
                    uncleNode.color = Black;            // 将叔叔节点置为黑色
                    node.parent.parent.color = Red; // 将祖父节点置为红色
                    node = node.parent.parent;  // 将当前节点置为祖父节点
                    continue;   // 重新进入循环
                }
                if (node == node.parent.right) { // 若当前节点是父节点的右节点
                    node = node.parent; // 将当前节点指向父节点
                    rotateLeft(node);   // 将当前节点左旋
                }
                node.parent.color = Black;      // 将当前节点父节点设置为黑色
                node.parent.parent.color = Red; // 将当前节点祖父节点设置为红色
                rotateRight(node.parent.parent);   // 将祖父节点右旋
            } else {
                uncleNode = node.parent.parent.left;
                if (uncleNode != nil && uncleNode.color == Red) {
                    node.parent.color = Black;
                    uncleNode.color = Black;
                    node.parent.parent.color = Red;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.left) {
                    node = node.parent;
                    rotateRight(node);
                }
                node.parent.color = Black;
                node.parent.parent.color = Red;
                rotateLeft(node.parent.parent);
            }
        }
        root.color = Black;
    }

    void rotateLeft(Node node) {
        if (node.parent != nil) { // 若当前节点父节点不为null
            if (node == node.parent.left) { // 若当前节点是父节点的左节点
                node.parent.left = node.right; // 将当前节点父节点的左节点设置为当前节点的右节点
            } else { // 若当前节点是父节点的右节点
                node.parent.right = node.right; // 将当前节点父节点的右节点设置为当前节点的右节点
            }
            node.right.parent = node.parent;    // 将当前节点的右节点的父节点设置为当前节点父节点
            node.parent = node.right;           // 将当前节点的父节点设置为当前节点的右节点
            if (node.right.left != nil) {       // 当前节点原来的右节点的左节点不为null
                node.right.left.parent = node;  // 将当前节点的原来的右节点的左节点的父节点设置为当前节点
            }
            node.right = node.right.left;       // 将当前节点的右节点设置为，原来右节点的左节点
            node.parent.left = node;            // 将当前节点设置为其原来的右节点的左节点
        } else {    // 若当前节点父节点为null
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = nil;
            root = right;
        }
    }

    void rotateRight(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }
            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != nil) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        } else {
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = nil;
            root = left;
        }
    }

    public void creatTree() {
        int[] data = new int[]{23, 32, 15, 221, 3};
        Node node;
        System.out.println(Arrays.toString(data));
        for (int i = 0; i < data.length; i++) {
            node = new Node(data[i]);
            insert(node);
        }
        printTree(root);
    }

    public static void main(String[] args) {
        RedBlackTree bst = new RedBlackTree();
        bst.creatTree();
    }
}
