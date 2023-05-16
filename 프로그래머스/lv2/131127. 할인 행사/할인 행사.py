def solution(want, number, discount):
    answer = 0
    want_table = dict(zip(want,number))
    discount_table = {}
    for i in range(len(discount)-9):
        discount_table = {}
        cnt = 0
        for j in range(i,i+10):
            if discount[j] not in discount_table:
                discount_table[discount[j]] = 1
            else:
                discount_table[discount[j]] += 1

        for j in want:
            try:
                if discount_table[j] < want_table[j] :
                    break
            except:
                break
            cnt+=1
        if cnt == len(want):   
            print(discount_table)
            answer +=1    
            
    
    return answer