package binaryTree;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {

        if (root.left == null && root.right == null) {
            return 0;
        }
        int maxHeight = calculateHeight(root);

        return maxHeight;

    }

    public static int calculateHeight(Node node) {

        int leftHeight = 0;
        int rightHeight = 0;

        if (node.left != null) {
            leftHeight = 1 + calculateHeight(node.left);
        }
        if (node.right != null) {
            rightHeight = 1 + calculateHeight(node.right);
        }
        return Math.max(leftHeight, rightHeight);


    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}