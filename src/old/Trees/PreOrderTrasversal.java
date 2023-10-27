package javaSolutions.src.old.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PreOrderTrasversal {

    private static void preOrder(Node root) {
        var res = go(root, new ArrayList<>());
        Collections.sort(res);
        for (int i :
                res) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> go(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.data);
            list = go(node.left, list);
            list = go(node.right, list);
        }
        return list;
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
        preOrder(root);
    }
}