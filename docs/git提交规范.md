# Git 提交规范（学习项目专用）

> 目标：让 commit 历史成为学习日志——一个月后回看 `git log`，能清楚看到自己学了什么、踩过什么坑。

## 一、提交节奏：按「一件事完成」提交，不按时间

| 场景 | 提交时机 | 示例 |
|---|---|---|
| 完成一个练习 | 运行通过后 | `feat(exercises): 完成数组反转练习` |
| 更新笔记 | 一节笔记写完 | `docs(notes): 补充类型转换笔记` |
| 修复自己的 bug | 问题解决后 | `fix: 修复冒泡排序越界问题` |
| 模块通关 | 综合任务验收通过 | 提交 + 打 tag `v0.1.0-javase-语言基础` |
| 每天结束 | 至少 1 个提交 | 哪怕只学了半小时，也要留下痕迹 |

最低要求：**一天至少一次提交**，宁可拆小也不要攒一周再提交。

## 二、消息格式：Conventional Commits

```
<type>(<scope>): <描述>
```

常用 type：

- `feat:` 完成练习或项目功能
- `docs:` 笔记、大纲、文档更新
- `fix:` 修复自己代码的 bug（这类提交最有价值，记录踩过的坑）
- `test:` 为练习/项目编写测试
- `chore:` 环境搭建、结构调整

常用 scope（作用域，可选但建议加）：

- `exercises` — 练习
- `notes` — 学习笔记
- `project` — 阶段项目
- `docs` — 文档

示例：

```
feat(exercises): 完成学生成绩统计工具
docs(notes): 补充数组遍历笔记
fix(project): 修复 HTTP 请求解析的空指针
test(project): 为成绩统计工具添加 JUnit 用例
chore: 配置 .gitignore 忽略编译输出
```

## 三、关键原则

1. **提交的代码必须能编译运行。** 写一半的代码不要提交；学习期不使用 WIP 提交，避免积累坏习惯。
2. **一个提交只做一件事。** 不要「笔记 + 练习 + 项目」混在一个提交里。
3. **拒绝空泛消息。** `改动`、`update`、`test` 这类消息等于没写；每条消息要让人知道"这一步完成了什么"。
4. **不要为了提交而提交。** 没有明确完成内容时，宁可不提交。
5. **学习阶段只用 main 分支。** 等到 mini-http-server 阶段再练 feature 分支 + merge。

## 四、里程碑（tag）

每个模块验收通过后，打一个 tag 作为里程碑：

```
git tag v0.1.0-javase-语言基础
git tag v0.2.0-javase-面向对象
```

规则：`v<模块编号>.<小版本>-<模块名>`。阶段项目完成打 `v1.0.0-javase-结业`。

## 五、结合本仓库结构的建议节奏

```
docs/           → 大纲、规范类文档更新       docs:
modules/01-javaSE/notes/     → 每节笔记      docs(notes):
modules/01-javaSE/exercises/ → 每题完成      feat(exercises):
modules/01-javaSE/project/   → 每加一个功能  feat(project):
```

日常流程：写代码/笔记 → 本地验证（编译、运行）→ `git add` 相关文件 → `git commit` → 当天收尾 `git push`（如配置了远程）。

## 六、目录与包命名规范（练习代码）

练习目录统一使用英文包名格式：**目录名 = 包名**，每个 Java 文件第一行必须声明对应的 `package`。

| 目录 | package 声明 | 用途 |
|---|---|---|
| `exercises/lesson01/` | `package lesson01;` | 第 1 课练习 |
| `exercises/lesson01/solutions/` | `package lesson01.solutions;` | 第 1 课参考答案（子包） |
| `exercises/lessonNN/` | `package lessonNN;` | 后续课程依此类推 |

规则：

1. 目录名只用小写字母 + 数字（`lesson01`），**禁止中文、连字符、空格**——包名必须是合法 Java 标识符
2. 每个 `.java` 文件第一行写 `package lessonXX;`，与所在目录一一对应
3. 参考答案放入 `solutions/` 子目录并使用子包 `lessonXX.solutions`，避免与练习文件中的类重名（如 `Student`）
4. 所有课程目录共存于同一个源码根（`exercises`），无需手动切换 IDEA 源码根
5. 运行命令使用全限定名：`java -cp out lesson02.Exercise01`
6. 目录改名、加包属于结构调整，提交类型用 `chore(exercises):`

示例：

```
chore(exercises): 练习目录重构为包结构（lesson01 ~ lesson05）
feat(exercises): 完成 OOP 练习并加包 lesson02
```

## 七、回看历史

每周用一次 `git log --oneline --graph` 回顾本周提交，检查：

- 是否有空泛消息需要改进
- 是否每天都留下了提交
- 练习与笔记的比例是否均衡

历史质量 = 学习质量的缩影。