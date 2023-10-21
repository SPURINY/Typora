# tutorials

### 1.**改变盘符**用cd换不了

```shell
C:\Users\purin>D:
D:\>
```

### 2.可能只是没切换到合适的**目录**

```shell
/d/LearnResource/my_note/Typora/SICP (main)
$ python lab01.py -v
C:\Users\purin\AppData\Local\Programs\Python\Python39\python.exe: can't open file 'D:\LearnResource\my_note\Typora\SICP\lab01.py': [Errno 2] No such file or directory


/d/LearnResource/my_note/Typora/SICP (main)
$ cd D:\LearnResource\my_note\Typora\SICP
bash: cd: D:LearnResourcemy_noteTyporaSICP: No such file or directory     


/d/LearnResource/my_note/Typora/SICP (main) 
$ dir
cs61a_sicp.md  hw01-Code  lab00  lab01-Code

/d/LearnResource/my_note/Typora/SICP (main) 
$ cd lab01-Code

/d/LearnResource/my_note/Typora/SICP/lab01-Code (main)
$ python lab01.py -v
Trying:
    both_odd(-1, 1)
Expecting:
    True
ok
Trying:
    both_odd(2, 1)
Expecting:
    False
ok
Trying:
    factorial(3)
Expecting:
    6
ok
Trying:
    factorial(5)
Expecting:
    120
ok
Trying:
    is_triangle(2, 1, 3)
Expecting:
    False
ok
Trying:
    is_triangle(5, -3, 4)
Expecting:
    False
ok
Trying:
    is_triangle(2, 2, 2)
Expecting:
    True
ok
Trying:
    max_digit(10)
Expecting:
    1
```

### 3.doctest

①在docstring里写好测试用例②导包＋`if ``__name__ == "__main__":`③运行时自动测试
    doctest.testmod()`

```python
import doctest

def factorial(n):
    """
    Calculate the factorial of a number.

    >>> factorial(5)
    120
    >>> [factorial(n) for n in range(6)]
    [1, 1, 2, 6, 24, 120]
    """
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)

if __name__ == "__main__":
    doctest.testmod()

```

### 4.python -i hello.py  进入交互模式

```python
def whomax(x,y):
    return max(x,y)
```

```shell
python -i hello.py
>>> whomax(6,9)
9
>>>
```

### 5.higher-order funtions(高阶函数)

-  “可以接收其他函数作为参数”或“可以把函数当作返回值”的函数。

  #### 1.接收其他函数作为参数

```python
#1+2+3+4+5
def sum_common(n):
    i,res=1,0
    while i<=n:
        res=res+i
        i=i+1
    return res
#1^3+...+5^3
def sum_tri(n):
    i,res=1,0
    while i<=n:
        res=res+pow(i,3)
        i=i+1
    return res

```

- 但放眼一看两个函数只有+i和+pow(i,3)一处不一样

- 抽出来,做成function

  ```python
  def common(k):
      return k
  def tri(k):
      return pow(k,3)
  ```

  - 原来的sum_xx的function则可抽成：原函数体＋term（上两个的代称

  ```python
  def dum_all(n,term):
      i,res=1,0
      while i<=n:
          res=res+term(i)
          i=i+1
      return res
  ```

  - 最初的sum_xx可改写成直接调用sum_all

  ```python
  def sum_common(n):
      return sum_all(n,common)
  def sum_tri(n):
      return sum_all(n,tri)
  ```

全部代码：

```python
def common(k):
    return k
def tri(k):
    return pow(k,3)

def sum_all(n,term):
    i,res=1,0
    while i<=n:
        res=res+term(i)
        i=i+1
    return res
#1+2+3+4+5
#1^3+...+5^3
def sum_common(n):
    return sum_all(n,common)
def sum_tri(n):
    return sum_all(n,tri)
```

#### 2.把函数当作返回值

```python

```



### 6.assert断言

```python
assert condition,"message"
```

如果condition为false的话会`AssertionError` 异常，并打印“message”；true，无事发生

### 7.abs(x - y) < tolerance判断浮点数是否相等

- 为了避免由于浮点数精度问题而导致的错误判断，通常使用一个足够小的容差（tolerance）值来比较两个浮点数的差的绝对值。如果两个浮点数的差的绝对值小于容差值，我们可以认为它们是相等的。
  - 如下例中`tolerance=1e-15`

```python
#黄金比例
#improve迭代求精，并没指出具体方式，把实现留给close（判断）和update（do）
def improve(close,update,guess=1):
    while not close(guess):
        guess=update(guess)
    return guess
##黄金比例可以通过反复叠加任何正数的倒数加上 1 来计算（do
##它比它的平方小 1（判断
def golden_update(x):
    return 1/x+1
def golden_close(x):
    return judge(x*x,x+1)

def judge(x,y,tolerance=1e-15):
    return abs(x-y)<tolerance
print(improve(golden_close,golden_update,1.5))
```

