package javaSolutions.src.old.initialPractice;

public class MockInt {
    // A tree find a node in the tree.
    // Give a value n find the node with the tree.

    //

    /**
     *                         1
     *                 3       2      7
     *               5      6     4  29   89
     *           11   12  9   8   13   4
     *
    * **/

    private static void findNode(Node root,  Node parent, int n) {
        //  arr = Node[2]
        // if root.val == n
        //    arr[0] = parent
        //    arr[1] = root
        // else
        //
        //     for node in root.children
        //         res[] = findNode(node, root, n)
        //          if (arr[1] != null)
        //              return res
       // return arr;
    }



    private static void findNeighbors(Node root, int n) {
        // arr [] = findNode(root, null, n);
        // List<Node> res = new ArrayList<>()
        // if arr[0] != null
        //      res.add(arr[0])
        // for (node in arr[1].children)
        //      res.add(node)
        // return res
        //
    }

    public static void main(String[] args) {

//
//        CountOfNodes.Node root_2 = new CountOfNodes.Node(1);
//        root_2.children.add(new CountOfNodes.Node(2));
//        root_2.children.add(new CountOfNodes.Node(3));
//        root_2.children.add(new CountOfNodes.Node(7));
//        root_2.children.get(0).children.add(new CountOfNodes.Node(4));
//        root_2.children.get(0).children.add(new CountOfNodes.Node(5));
//        root_2.children.get(1).children.add(new CountOfNodes.Node(6));

        System.out.println((int) Long.parseLong("42"));
    }
}
