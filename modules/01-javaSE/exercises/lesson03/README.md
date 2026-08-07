# 03-核心API练习

> 配套笔记：`modules/01-javaSE/notes/03-核心API.md`
> 本目录包名：`lesson03`（参考答案在子包 `lesson03.solutions`）

## 流程

1. 先读完笔记，再打开练习
2. 每个练习文件里有 `// TODO` 标记，按题目要求补全代码
3. 编译运行，确保输出符合题目里的"预期"
4. **全部完成后**再看 `solutions/` 里的参考答案，逐行对比
5. 最后把代码发给我 review

## 编译运行命令

在 PowerShell 中先进入本目录：

```powershell
cd modules\01-javaSE\exercises\lesson03
javac -encoding UTF-8 -d out Exercise01.java
java -cp out lesson03.Exercise01
```

运行参考答案：

```powershell
javac -encoding UTF-8 -d out solutions\Solution01.java
java -cp out lesson03.solutions.Solution01
```

注意：

- 必须加 `-encoding UTF-8`（源文件里有中文注释）
- 加包后，运行命令要用"包名.类名"：`lesson03.Exercise01`
- 如果运行输出中文乱码，先执行 `chcp 65001` 再运行

## 规则

- 先自己做，卡住 20 分钟可以回看笔记，但不要看答案
- `solutions/` 里的代码是"参考答案"，不是"标准答案"，你的写法不同很正常
- 每个 TODO 完成后，在代码旁用注释写下你的理解（一行即可）
- 本课是 API 课，**查文档、用 AI 问方法**都是允许的，但别让 AI 直接写题