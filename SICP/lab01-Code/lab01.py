import doctest
def both_odd(a, b):
    """Returns True if both a and b are odd numbers.

    >>> both_odd(-1, 1)
    True
    >>> both_odd(2, 1)
    False
    """
    return (a % 2 == 1)and (b % 2 == 1) # You can replace this line!
#print(both_odd(5,0))
#print(both_odd(1,3))


def factorial(n):
    """Return the factorial of a positive integer n.

    >>> factorial(3)
    6
    >>> factorial(5)
    120
    """
    if n==1:  # YOUR CODE HERE
        return 1
    else:
        return n*factorial(n-1)
#print(factorial(3))

def is_triangle(a, b, c):
    """Given three integers (may be nonpositive), judge whether the three
    integers can form the three sides of a triangle.

    >>> is_triangle(2, 1, 3)
    False
    >>> is_triangle(5, -3, 4)
    False
    >>> is_triangle(2, 2, 2)
    True
    """
    if a+b>c and a+c>b and c+b>a:  # YOUR CODE HERE
        return True
    else:
        return False
#print(is_triangle(2, 2, 2))
#print(is_triangle(5, -3, 4))

def number_of_six(n):
    """Return the number of 6 in each digit of a positive integer n.

    >>> number_of_six(666)
    3
    >>> number_of_six(123456)
    1
    """
    num=0  # YOUR CODE HERE
    while n>0:
        temp=n%10
        m=n//10
        if temp==6:
            num=num+1
    return num
    print(number_of_six(1234596))

def max_digit(x):
    """Return the max digit of x.

    >>> max_digit(10)
    1
    >>> max_digit(4224)
    4
    >>> max_digit(1234567890)
    9
    >>> # make sure that you are using return rather than print
    >>> a = max_digit(123)
    >>> a
    3
    """
    m=0  # YOUR CODE HERE
    temp=0
    while x>0:
        temp=x%10
        m=x//10
        if temp>m:
            m=temp
    return m
#print(max_digit(1234596))

if __name__ == "__main__":
    doctest.testmod()