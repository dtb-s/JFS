package lesson05.solutions;

/**
 * 练习 1 参考答案：泛型类
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution01 {

    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        box1.set("hello");
        String s = box1.get();
        System.out.println(s);           // hello

        Box<Integer> box2 = new Box<>();
        box2.set(42);
        System.out.println(box2.get());  // 42

        Pair<String, Integer> p1 = new Pair<>("age", 18);
        System.out.println(p1.getKey() + " " + p1.getValue());   // age 18

        Pair<String, String> p2 = new Pair<>("name", "小明");
        System.out.println(p2.getKey() + " " + p2.getValue());   // name 小明
    }
}

class Box<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}