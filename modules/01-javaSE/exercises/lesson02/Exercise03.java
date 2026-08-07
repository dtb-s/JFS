package lesson02;

/**
 * 练习 3：抽象类、接口、多态
 * 配套笔记：notes/02-面向对象.md 第 9~10 节
 * <p>
 * 题目：补全 Circle、Rectangle 类（继承 Shape 并实现 Drawable），完成 main 中的测试。
 */
public class Exercise03 {

    public static void main(String[] args) {
        // TODO 1：创建对象并放入 Shape 数组
        // 创建 Circle(5) 和 Rectangle(4, 6)
        // 用 for 循环遍历数组，调用 describe()
        // 预期输出：
        // 这是一个圆形，面积 78.53981633974483
        // 这是一个矩形，面积 24.0

        // TODO 2：接口多态
        // 创建 Drawable 数组，装入 circle 和 rectangle
        // 循环调用 draw()，预期输出：
        // 画一个圆
        // 画一个矩形
    }
}

// 抽象类：已有实现，直接使用
abstract class Shape {
    String name;

    Shape(String name) {
        this.name = name;
    }

    abstract double area();

    void describe() {
        System.out.println("这是一个" + name + "，面积 " + area());
    }
}

// 接口：已有定义，直接使用
interface Drawable {
    void draw();
}

// TODO：Circle 继承 Shape 实现 Drawable
// 1. 属性：double radius
// 2. 构造方法：super("圆形")，接收 radius
// 3. 重写 area()：Math.PI * radius * radius
// 4. 重写 draw()：打印"画一个圆"
class Circle {
    // 你的代码
}

// TODO：Rectangle 继承 Shape 实现 Drawable
// 1. 属性：double width、double height
// 2. 构造方法：super("矩形")，接收 width、height
// 3. 重写 area()：width * height
// 4. 重写 draw()：打印"画一个矩形"
class Rectangle {
    // 你的代码
}