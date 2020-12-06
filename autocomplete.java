import java.util.*;
class tempCodeRunnerFile {
    static class Node {
        char c;
        int length;
        HashMap<Character, Node> children;
        public Node(char c) {
            this.c = c;
            this.length = -1;
            children = new HashMap<Character, Node>();
        }
    }
    static class Trie {
        Node root;
        public Trie() {
            root = new Node('0');
        }
        public void insert(String word) {
            Node node = root;
            for(char c: word.toCharArray()) {
                if(!node.children.containsKey(c)) {
                    node.children.put(c, new Node(c));
                }
                node = node.children.get(c);
            }
            node.length = word.length();
        }
        public Node search(String word) {
            Node node = root;
            for(char c: word.toCharArray()) {
                if(!node.children.containsKey(c)) {
                    return null;
                }
                node = node.children.get(c);
            }
            return node;
        }
    }
    public static List<String> autocomplete(String[] arr, String word) {
        List<String> res = new ArrayList<String>();
        // your code here
        Trie trie = new Trie();
        for(String str: arr) {
            trie.insert(str);
        }
        Node node = trie.search(word);
        if(node==null) {
            return res;
        }
        dfs(res, word, node);
        return res;
    }

    public static void dfs(List<String> res, String word, Node node) {
        if(node.length > -1) {
            res.add(word);
        }
        for(char c: node.children.keySet()) {
            dfs(res, word+c, node.children.get(c));
        }
    }

    public static void main(String args[]) {
        String[] arr = new String[]{"vin", "vind", "vindiy","vindiya", "singh", "sin", "ingh"};
        
        for(String word: autocomplete(arr, "sin")) {
            System.out.println(word);   
        }
    }
}