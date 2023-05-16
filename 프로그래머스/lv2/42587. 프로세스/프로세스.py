from collections import deque
def solution(priorities, location):
    answer = 0
    priorities_list = []
    temp = list(range(len(priorities)))
    temp = deque(temp)
    priorities = deque(priorities)
    for i in range(len(priorities)):
        num = priorities.index(max(priorities))
        temp.rotate(len(priorities)-num-1)
        priorities.rotate(len(priorities)-num-1)
        priorities_list.append(temp.pop())
        priorities.pop()
    answer = priorities_list.index(location)+1
    return answer