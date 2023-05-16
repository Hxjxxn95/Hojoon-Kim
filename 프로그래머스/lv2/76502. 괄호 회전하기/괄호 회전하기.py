from collections import deque
def Is_true(a):
    stack= []
    for i in range(len(a)):
        if a[i] =='[' or a[i]=='{' or a[i] == '(' :
            stack.append(a[i])
            continue
        elif a[i] == ')' and stack and stack[-1] == '(':
            stack.pop()


        elif a[i] == ']' and stack and stack[-1]=='[':
            stack.pop()


        elif a[i] == '}' and stack and stack[-1]=='{':
            stack.pop()
        else:
            return 0
    if len(stack) == 0 :
        return 1
    else:
        return 0

def solution(s):
    answer = 0
    answer+=Is_true(s)
    s = deque(list(s))
    for i in range(0,len(s)-1):
        s.rotate(-1)
        answer += Is_true(s)
    return answer