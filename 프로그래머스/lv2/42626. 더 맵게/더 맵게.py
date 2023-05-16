import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while(scoville[0]<K):
        try:    
            mix = heapq.heappop(scoville)+heapq.heappop(scoville)*2
            heapq.heappush(scoville,mix)
            answer +=1
        except:
            return -1
    return answer