package javaSolutions.src.old.Trees;

import java.util.Scanner;

public class BinaryTreeHeight {
    static int max = 0;
    public static int height(Node root) {
         go(root, 0);
         return max;
    }

    public static void go(Node node, int height){
        if (node != null){
            if (height > max) max = height;
            height++;
            go(node.left, height);
            go(node.right, height);
        }

    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
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
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }

}