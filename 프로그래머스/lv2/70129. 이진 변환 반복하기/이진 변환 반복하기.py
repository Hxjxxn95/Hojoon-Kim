def solution(s):
    answer = []
    cnt1  = 0
    cnt2 = 0
    while s!= '1':
        cnt2 += s.count('0')
        cnt1 += 1
        s= s.replace('0', '')
        s = bin(len(s))[2:]
        print(s)
    answer = [cnt1,cnt2]    
    return answer
