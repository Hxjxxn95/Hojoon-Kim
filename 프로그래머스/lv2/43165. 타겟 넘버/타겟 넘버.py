from itertools import combinations
def solution(numbers, target):
    answer = 0
    result = []
    for i in range(len(numbers)+1):
        result+=list(combinations(numbers,i))
    for i in range(len(result)):
        if sum(numbers)-2*sum(result[i]) == target:
            answer +=1
    return answer