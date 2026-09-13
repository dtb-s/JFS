# 11-单元测试与调试练习

> 配套笔记：`modules/01-javaSE/notes/11-单元测试与调试.md`
> 本目录包名：`lesson11`（参考答案在子包 `lesson11.solutions`）

## 环境准备（只需一次）

```powershell
cd modules\01-javaSE\exercises\lesson11
New-Item -ItemType Directory -Force lib | Out-Null
Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.12.2/junit-platform-console-standalone-1.12.2.jar" -OutFile "lib\junit-platform-console-standalone.jar"
```

（jar 已下载的话跳过。`lib/` 已被 .gitignore 忽略。）

## 流程

1. 先读完笔记，再打开练习
2. 每个练习是"生产类 + 测试类"一对：`Exercise01.java`（补全类）+ `Exercise01Test.java`（写测试）
3. 编译、运行测试，全部通过才算完成
4. **全部完成后**再看 `solutions/` 里的参考答案
5. 最后把代码发给我 review

## 编译运行命令

```powershell
# 编译（生产类 + 测试类一起）
javac -encoding UTF-8 -cp "lib\junit-platform-console-standalone.jar" -d out Exercise01.java Exercise01Test.java

# 运行测试（用 JUnit 控制台）
java -jar lib\junit-platform-console-standalone.jar --class-path out --scan-class-path
```

练习 3 的 BuggyCode 想手动跑：`java -cp out lesson11.Exercise03`

注意：

- 必须加 `-encoding UTF-8`（源文件里有中文注释）
- 加包后，运行命令要用"包名.类名"
- 如果运行输出中文乱码，先执行 `chcp 65001` 再运行

## 规则

- 先自己做，卡住 20 分钟可以回看笔记，但不要看答案
- `solutions/` 里的代码是"参考答案"，不是"标准答案"
- 练习 3 请**先用 IDEA 断点调试找 bug**，再修复（这是本课最重要的练习）