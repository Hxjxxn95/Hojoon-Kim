def solution(n, left, right):
    answer = []
    square = []
    for i in range(left//n+1,right//n+2):
        for j in range(i):
            square.append(i)
        for j in range (i+1,n+1):
            square.append(j)
    answer = square[left-n*(left//n):right-n*(left//n)+1]      
    return answer