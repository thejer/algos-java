package javaSolutions.initialPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfNodes {

    static Node findNode(int u, Node root) {
        Node n = null;
        if (root == null) return n;
        if (root.val == u) {
            n = root;
        } else {
            for (Node node : root.children) {
                Node k = findNode(u, node);
                if (k != null)
                    n = k;
            }
        }
        return n;
    }

    static int findChildrenCount(Node root, String s, char c) {
        int count = 0;
        if (s.charAt(root.val - 1) == c) {
            count += 1;
            System.out.println("char at " + s.charAt(root.val - 1));
        }
        for (Node node : root.children) {
            count += findChildrenCount(node, s, c);
        }

        return count;
    }

    // Add any helper functions you may need here

    static int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        // Write your code here
        int size = queries.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            Query query = queries.get(i);
            Node n = findNode(query.u, root);
            result[i] = findChildrenCount(n, s, query.c);
        }
        return result;
    }

    public static void main(String[] args) {
        int n_1 = 3, q_1 = 1;
        String s_1 = "aba";
        Node root_1 = new Node(1);
        root_1.children.add(new Node(2));
        root_1.children.add(new Node(3));
        ArrayList<Query> queries_1 = new ArrayList<>();
        queries_1.add(new Query(1, 'a'));

        int n_2 = 7, q_2 = 3;
        String s_2 = "abaacab";
        Node root_2 = new Node(1);
        root_2.children.add(new Node(2));
        root_2.children.add(new Node(3));
        root_2.children.add(new Node(7));
        root_2.children.get(0).children.add(new Node(4));
        root_2.children.get(0).children.add(new Node(5));
        root_2.children.get(1).children.add(new Node(6));
        ArrayList<Query> queries_2 = new ArrayList<>();
        queries_2.add(new Query(1, 'a'));
        queries_2.add(new Query(2, 'b'));
        queries_2.add(new Query(3, 'a'));

        System.out.println(Arrays.toString(countOfNodes(root_1, queries_1, s_1)));
    }

    // Tree Node
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Node n :
                    children) {
                sb.append(n.val).append(" ");
            }
            return "Node{" +
                    "val=" + val +
                    ", children=" + sb +
                    '}';
        }
    }

    static class Query {
        int u;
        char c;

        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }
}
