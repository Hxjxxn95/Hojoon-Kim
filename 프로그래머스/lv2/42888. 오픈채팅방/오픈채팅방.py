def solution(record):
    answer = []
    record_list = []
    id_table = {}
    
    for string in record :
        record_list.append(string.split(' '))
        
    for i in range(len(record_list)) :
        try:
            id_table[record_list[i][1]] = record_list[i][2]
        except:
            pass
    for i in range(len(record_list)):
        if record_list[i][0] == 'Enter':
            answer.append(id_table[record_list[i][1]]+'님이 들어왔습니다.')     
        elif record_list[i][0] == 'Leave':
            answer.append(id_table[record_list[i][1]]+'님이 나갔습니다.')
        else:
            pass
    return answer