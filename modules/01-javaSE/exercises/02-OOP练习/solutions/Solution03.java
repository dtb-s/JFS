/**
 * 练习 3 参考答案：抽象类、接口、多态
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution03 {

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);

        // 抽象类多态：Shape 数组
        Shape[] shapes = {circle, rectangle};
        for (Shape shape : shapes) {
            shape.describe();
        }

        // 接口多态：Drawable 数组
        Drawable[] drawables = {circle, rectangle};
        for (Drawable d : drawables) {
            d.draw();
        }
    }
}

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

interface Drawable {
    void draw();
}

class Circle extends Shape implements Drawable {
    double radius;

    Circle(double radius) {
        super("圆形");
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("画一个圆");
    }
}

class Rectangle extends Shape implements Drawable {
    double width;
    double height;

    Rectangle(double width, double height) {
        super("矩形");
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("画一个矩形");
    }
}