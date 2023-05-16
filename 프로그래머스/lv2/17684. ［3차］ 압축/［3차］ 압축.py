def solution(msg):
    answer = []
    table = {}
    for key , value in enumerate(range(65,91),1):
        table[chr(value)] = key
    num = 0
    while num < len(msg)  :
        k = 1
        if msg[num:] in table.keys():
            print(msg[num:])
            answer.append(table[msg[num:]])
            print(table)
            return answer
        
        while num+k < len(msg) and msg[num:num+k] in table.keys():
            k = k + 1
        table[msg[num:num+k]] = len(table) +1

        
        answer.append(table[msg[num:num+k-1]])
        
        num += k -1
    print(table)
    return answer
