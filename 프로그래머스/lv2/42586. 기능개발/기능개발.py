def solution(progresses, speeds):
    answer = []
    temp = []
    for i in range(len(progresses)):
        if (100-progresses[i])%speeds[i]>0:         
            temp.append((100-progresses[i])//speeds[i]+ 1)
        else:
            temp.append((100-progresses[i])//speeds[i])
    print(temp)
    cnt = 0
    temp_max=temp[0]
    for i in range(len(temp)):
        if temp[i] > temp_max:
            temp_max = temp[i]
            answer.append(cnt)
            cnt = 1
        else:
            cnt+=1
    answer.append(cnt)
    return answer