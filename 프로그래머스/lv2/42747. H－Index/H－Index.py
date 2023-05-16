def solution(citations):
    answer = 0
    citations = sorted(citations)
    for i in range(len(citations)):
        if len(citations)-i <= citations[i] :
            answer +=1
            
    return answer