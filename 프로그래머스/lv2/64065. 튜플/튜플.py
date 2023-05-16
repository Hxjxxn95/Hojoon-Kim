def solution(s):
    answer = []
    temp = []
    s = s[2:len(s)-2]
    s= s.split('},{')
    s = sorted(s,key=len)
    for i in s:
        temp.append(set(map(int,i.split(','))))

    answer.append(list(temp[0])[0])
    for i in range(len(temp)-1):
        a = list(temp[i+1]-temp[i])
        answer.append(a[0])      
    return answer