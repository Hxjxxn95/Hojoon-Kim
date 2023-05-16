import itertools
def solution(k, dungeons):
    answer = -1
    k_copy = k
    max = 0
    dungeons_len = len(dungeons)
    dungeons_son = list(itertools.permutations(dungeons,dungeons_len ))
    for i in range(0,len(dungeons_son)):
        k = k_copy
        cnt = 0
        for j in range(len(dungeons_son[i])):
            if k >= dungeons_son[i][j][0] :
                cnt+=1
                k-= dungeons_son[i][j][1]
            else:
                break
        if cnt > max :
            max = cnt
    answer = max    
    return answer