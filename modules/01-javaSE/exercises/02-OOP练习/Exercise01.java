/**
 * 练习 1：类、构造方法、封装
 * 配套笔记：notes/02-面向对象.md 第 2~4 节
 *
 * 题目：补全 Student 类，并在 main 中完成测试，使输出符合"预期"。
 */
public class Exercise01 {

    public static void main(String[] args) {
        // TODO 1：用无参构造创建对象 s1
        Student s1 = new Student();

        // TODO 2：用 setter 给 s1 设置姓名"小明"、年龄 18
        // 然后调用 introduce()，预期输出：我叫小明，今年 18 岁

        // TODO 3：用有参构造创建对象 s2（姓名"小红"，年龄 20）
        // 调用 introduce()，预期输出：我叫小红，今年 20 岁

        // TODO 4：测试年龄校验
        // 给 s1 设置年龄 -5，预期打印：年龄不合法：-5
        // 再给 s1 设置年龄 25，打印 getAge()，预期：25

        // TODO 5（选做）：继续测试
        // 给 s1 设置年龄 200，预期打印：年龄不合法：200
    }
}

// TODO：补全 Student 类
// 1. 私有属性：String name、int age
// 2. 无参构造：调用 this("未命名", 0)
// 3. 有参构造：Student(String name, int age)，用 this.xxx = xxx 赋值
// 4. getter/setter：
//    - setName / getName
//    - setAge：年龄不合法（< 0 或 > 150）时打印"年龄不合法：" + age 并拒绝修改
//    - getAge
// 5. introduce()：打印 "我叫" + name + "，今年" + age + "岁"
class Student {
    // 你的代码
}