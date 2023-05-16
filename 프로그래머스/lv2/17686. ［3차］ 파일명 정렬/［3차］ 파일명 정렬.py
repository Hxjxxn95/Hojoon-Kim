import re
def solution(files):
    answer = []
    temp = []
    for file in files:
        temp.append([file,re.findall(r'\D+',file)[0].lower(),re.findall(r'\d+',file)[0]])
        
    temp = sorted(temp,key = lambda x: (x[1],int(x[2])))
    for i in range(len(temp)):
        answer.append(temp[i][0])
    return answer