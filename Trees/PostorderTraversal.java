package javaSolutions.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostorderTraversal {
    private static void preOrder(Node root) {
        List<Integer> res = go(root, new ArrayList<>());
        for (int i = res.size()-1; i >= 0; i--) {
            System.out.print(res.get(i) + " ");
        }
    }

    public static List<Integer> go(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.data);
            list = go(node.right, list);
            list = go(node.left, list);
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