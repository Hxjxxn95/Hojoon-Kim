from functools import reduce  
def solution(clothes):
    answer = 0
    clothes_table = {}
    for i in range(len(clothes)) :
        if clothes[i][1] not in clothes_table:
            clothes_table[clothes[i][1]] = 1
        else:
            clothes_table[clothes[i][1]] += 1
    value_list = clothes_table.values()
    value_list = list(map(lambda x : x+1,value_list))
    print(value_list)
    answer = reduce(lambda x,y:x*y,value_list)-1
    return answer