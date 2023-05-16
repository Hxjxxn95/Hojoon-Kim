from collections import deque
def solution(bridge_length, weight, truck_weights):
    truck_table = {}
    for key,value in enumerate(range(len(truck_weights))):
        truck_table[key] = 0
    cnt = 0
    bridge_list = []
    num = 0
    break_num = 0
    current_weight = 0
    while break_num < len(truck_weights):
        
        if truck_table[break_num] == bridge_length-1:
            break_num += 1
            current_weight -= bridge_list.pop(0)
            
            
        for i in range(break_num,num):
            truck_table[i] += 1
        
        if num<len(truck_weights) and current_weight + truck_weights[num] <= weight and len(bridge_list) + 1 <= bridge_length :
            bridge_list.append(truck_weights[num])
            current_weight += truck_weights[num]           
            num += 1

        cnt += 1
    answer = cnt
    return answer