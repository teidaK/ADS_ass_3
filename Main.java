
public class Main {
    public static void main(String[] args) {
        // Создаем объект дерева BST
        BST<Integer, String> tree = new BST<>();

        // Добавляем элементы в дерево
        tree.put(5, "Five");
        tree.put(3, "Three");
        tree.put(7, "Seven");
        tree.put(2, "Two");
        tree.put(4, "Four");
        tree.put(6, "Six");
        tree.put(8, "Eight");

        // Пример использования iterator() для обхода дерева и получения узлов Node
        for (BST.Node node : tree.iterator()) {
            System.out.println("Key: " + node.key + ", Value: " + node.val);
        }

        // Пример использования iteratorKeyValue() для обхода дерева и получения пар KeyValue
        for (KeyValue<Integer, String> kv : tree.iteratorKeyValue()) {
            System.out.println("Key: " + kv.key + ", Value: " + kv.value);
        }
    }
}
