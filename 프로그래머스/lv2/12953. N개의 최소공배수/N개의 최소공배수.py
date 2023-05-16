def  gcd(x, y):
    while y:
        x, y = y, x % y
    return x
def lcm(x, y):
    return x * y // gcd(x,y)
def solution(arr):
    temp = 1
    for i in arr:
        temp = lcm(temp,i)
    return temp