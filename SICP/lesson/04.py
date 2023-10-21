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
