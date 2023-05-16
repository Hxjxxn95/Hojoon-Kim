def solution(A,B):
    return  sum(map(lambda x,y : x*y,sorted(A),sorted(B,reverse=True)))