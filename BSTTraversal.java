
import java.util.*;
class tempCodeRunnerFile {
    static class Node {
        int val;
        Node left, right;
        public Node(int val) {
            this.val = val;
        }
    }
    public static int findKthLargest(Node root, int k) {
        if(root==null) {
            return -1;
        }
        Stack<Node> stack = new Stack();
        Node node = root;
        while(!stack.isEmpty() || node!=null) {
            while(node!=null) {
                stack.push(node);
                node = node.right;
            }
            Node curr = stack.pop();
            if(--k == 0) return curr.val;
            node = curr.left;
        }
        return -1;
    }

    public static int findKthLargestInorder(Node root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(list, root);
        return list.get(list.size()-k);
    }

    public static int findLargest(Node root) {
        if(root==null) {
            return -1;
        }
        if(root.right==null) {
            return root.val;
        }
        Node node = root;
        while(node.right!=null) {
            node = node.right;
        }
        return node.val;
    }
    public static void inorder(List<Integer> list, Node node) {
        if(node==null) {
            return;
        }
        inorder(list, node.left);
        list.add(node.val);
        inorder(list, node.right);
    }
    public static List<Integer> inorderIterative(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) {
            return res;
        }
        Stack<Node> stack = new Stack();
        Node node = root;
        while(!stack.isEmpty() || node!=null) {
            while(node!=null) {
                stack.push(node);
                node = node.left;
            }
            Node curr = stack.pop();
            res.add(curr.val);
            node = curr.right;
        }
        return res;
    }
    public static void main(String args[]) {
        Node root = new Node(45);
        Node root35 = new Node(35);
        Node root60 = new Node(60);
        Node root25 = new Node(25);
        Node root40= new Node(40);
        Node root20 = new Node(20);
        Node root29 = new Node(29);
        Node root50 = new Node(50);
        Node root52 = new Node(52);
        Node root51 = new Node(51);
        root.left = root35;
        root.right = root60;
        root35.left = root25;
        root35.right = root40;
        root25.left = root20;
        root25.right = root29;
        root60.left = root50;
        root50.right = root52;
        root52.left = root51;
        //int res = findKthLargestInorder(root, 3);
        //int res1 = findLargest(root);
        //List<Integer> res3 = inorderIterative(root);
        int res4 = findKthLargest(root, 5);
        //System.out.println("kth largest using inorder "+res);
        //System.out.println("largest: "+res1);
        // for(int num: res3) {
        //     System.out.println(" "+num);
        // }
        System.out.println("kth largest: "+res4);
    }
}