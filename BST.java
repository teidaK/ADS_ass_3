import java.util.ArrayList;
import java.util.List;
public class BST<K extends Comparable<K>, V> {
        private Node root;
        private int size; // Добавлено поле "size"

        public class Node {
            public K key;
            public V val;
            public Node left, right;

            public Node(K key, V val) {
                this.key = key;
                this.val = val;
            }
            public K getKey() {
                return key;
            }

            public V getValue() {
                return val;
            }
        }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else if (cmp > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;

        return node;
    }

    public V get(K key) {
        Node node = get(root, key);
        return node != null ? node.val : null;
    }

    private Node get(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else
            return node;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        size--;
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public Iterable<Node> iterator() {
        List<Node> nodes = new ArrayList<>();
        inOrderTraversalNode(root, nodes);
        return nodes;
    }

    // Метод для обхода дерева и получения пар KeyValue
    public Iterable<KeyValue<K, V>> iteratorKeyValue() {
        List<KeyValue<K, V>> nodes = new ArrayList<>();
        inOrderTraversalKeyValue(root, nodes);
        return nodes;
    }

    private void inOrderTraversalNode(Node node, List<Node> nodes) {
        if (node == null) return;
        inOrderTraversalNode(node.left, nodes);
        nodes.add(node);
        inOrderTraversalNode(node.right, nodes);
    }

    // Общий метод для обхода дерева в порядке возрастания с добавлением пар KeyValue
    private void inOrderTraversal(Node node, List<KeyValue<K, V>> nodes) {
        if (node == null) return;
        inOrderTraversal(node.left, nodes);
        nodes.add(new KeyValue<>(node.key, node.val));
        inOrderTraversal(node.right, nodes);
    }
    private void inOrderTraversalKeyValue(Node node, List<? super KeyValue<K, V>> nodes) {
        if (node == null) return;
        inOrderTraversalKeyValue(node.left, nodes);
        nodes.add(new KeyValue<>(node.key, node.val));
        inOrderTraversalKeyValue(node.right, nodes);
    }

}


