package lesson09.solutions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * 练习 3 参考答案：注解 + 反射（模拟测试框架）
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution03 {

    public static void main(String[] args) throws Exception {
        RunMeRunner.run(MyTests.class);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RunMe {
}

class RunMeRunner {

    public static void run(Class<?> clazz) throws Exception {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunMe.class)) {
                method.setAccessible(true);
                System.out.println("执行测试：" + method.getName());
                method.invoke(clazz.getDeclaredConstructor().newInstance());
            }
        }
    }
}

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