class tempCodeRunnerFile {
	static class Node {
		int val;
		Node left, right;
		public Node(int val) {
			this.val = val;
        }
    }
    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(Node root) {
        return helper(root);
    }
    public static int helper(Node node) {
        if(node==null) {
            return 0;
        }
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        return node.val+Math.max(left, right);
    }
    public static int maxPathSumNoRoot(Node root) {
        if(root==null) {
            return 0;
        }
        helper1(root);
        return max;
    }
    public static int helper1(Node node) {
        if(node==null) {
            return 0;
        }
        int left = Math.max(helper1(node.left), 0);
        int right = Math.max(helper1(node.right), 0);
        int sum = node.val + left + right;
        max = Math.max(max, sum);
        return node.val+Math.max(left, right);
    }
    public static void main(String args[]) {
        Node root = new Node(2);
        Node node10 = new Node(10);
        Node node5 = new Node(5);
        Node node1 = new Node(1);
        Node node4 = new Node(4);
        Node node4right = new Node(10);
        root.left = node10;
        root.right = node5;
        node10.right = node1;
        node5.left = node4;
        node5.right = node4right;
        int val = maxPathSumNoRoot(root);

        System.out.println(val);
    }
}
