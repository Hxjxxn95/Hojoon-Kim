import collections
def solution(x, y, n):
    answer = 0
    cur_list = [0]*1000001
    cur_list[x] = 1
    q = collections.deque()
    q.append(x)
    while q:
        temp = q.popleft()
        for x in (temp * 2, temp * 3, temp + n):
            if 0 <= x <= 1000000 and cur_list[x] == 0:
                cur_list[x]= cur_list[temp]+1
                q.append(x)
    answer = cur_list[y] -1        
    return answer