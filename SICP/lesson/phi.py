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

def compose1(n):
        def h(x):
            return n+x
        return h
print(compose1(5))
