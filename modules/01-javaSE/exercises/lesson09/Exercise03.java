package lesson09;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * 练习 3：注解 + 反射（模拟测试框架）
 * 配套笔记：notes/09-反射与注解.md 第 4~6 节
 * <p>
 * 题目：定义 @RunMe 注解，补全 RunMeRunner，运行 MyTests 中被注解标记的方法。
 */
public class Exercise03 {

    public static void main(String[] args) throws Exception {
        // TODO 1：调用 RunMeRunner.run(MyTests.class)
        // 预期输出（顺序不要求）：
        // 执行测试：testAdd
        // 1 + 1 = 2
        // 执行测试：testHello
        // hello
        // 注意：testNotMarked 没有被执行（没有 @RunMe）
    }
}

// TODO：定义 @RunMe 注解
// 1. @Retention(RetentionPolicy.RUNTIME)（必须，否则反射读不到）
// 2. @Target(ElementType.METHOD)（只能贴方法）
// 3. 不需要成员
@RunMe
@interface RunMe {
}

// TODO：补全 RunMeRunner
// 1. 静态方法 run(Class<?> clazz)
// 2. 遍历 clazz.getDeclaredMethods()
// 3. 方法上有 @RunMe 注解时（method.isAnnotationPresent(RunMe.class)）：
//    - setAccessible(true)
//    - 打印 "执行测试：" + method.getName()
//    - method.invoke(clazz.getDeclaredConstructor().newInstance())（每次新建对象；getConstructor 拿不到非 public 构造）
class RunMeRunner {
    // 你的代码
}

// 已有测试类，直接使用
class MyTests {

    @RunMe
    public void testAdd() {
        System.out.println("1 + 1 = 2");
    }

    @RunMe
    public void testHello() {
        System.out.println("hello");
    }

    public void testNotMarked() {
        System.out.println("我不会被执行");
    }
}