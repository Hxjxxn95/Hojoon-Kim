def solution(s):
    answer = ''
    s_list = list(map(int,s.split(' ')))
    answer = str(min(s_list))+' '+str(max(s_list))
    return answer