def solution(n):
    answer = 0
    cnt = 1
    num1 = 0
    num2 = 1
    num3 = 0
    while cnt != n:
        num3 = num1 + num2
        num1 = num2
        num2 = num3
        cnt+= 1
    answer =  num3%1234567
    return answer