
def solution(people, limit):
    answer = 0
    people = sorted(people)
    little_index = 0
    big_index = len(people) -1
    while little_index <= big_index:
        if people[little_index] + people[big_index] > limit:
            answer+=1
            big_index -=1
        else:
            answer += 1
            big_index -= 1
            little_index += 1
    
    
    return answer
