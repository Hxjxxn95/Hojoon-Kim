def solution(topping):
    answer = 0
    total_table = {}
    bro_table = set()
    for i in topping:
        if i not in total_table:
            total_table[i] = 1
        else:
            total_table[i] += 1
    for i in topping:
        total_table[i] -= 1
        bro_table.add(i)
        if total_table[i] == 0:
            del total_table[i]
        if len(bro_table) == len(total_table):
            answer += 1
        elif len(bro_table) > len(total_table):
            return answer
    return answer