package lesson05;

/**
 * 练习 1：泛型类
 * 配套笔记：notes/05-泛型与Lambda.md 第 2 节
 * <p>
 * 题目：补全 Box 和 Pair 类，并在 main 中测试。
 */
public class Exercise01 {

    public static void main(String[] args) {
        // TODO 1：Box<String> 存 "hello"，取出来赋值给 String 变量并打印
        // 预期：hello
        // 再创建 Box<Integer> 存 42，打印，预期：42
        // 体会：不同类型不用强转，取出来直接能用

        // TODO 2：Pair<String, Integer> 存 ("age", 18)，分别打印 key 和 value
        // 预期：age 18
        // 再创建 Pair<String, String> 存 ("name", "小明")，打印，预期：name 小明
    }
}

// TODO：补全 Box<T>
// 1. 私有字段 T item
// 2. set(T item) / get()
class Box<T> {
    // 你的代码
}

// TODO：补全 Pair<K, V>
// 1. 私有字段 K key、V value
// 2. 构造 Pair(K key, V value)
// 3. getKey() / getValue()
class Pair<K, V> {
    // 你的代码
}