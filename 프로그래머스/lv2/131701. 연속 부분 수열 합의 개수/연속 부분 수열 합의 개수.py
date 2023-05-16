def solution(elements):
    answer = 0
    num = len(elements)
    elements+=elements
    print(elements)
    num_list = []
    for i in range(1,num+1):
        for j in range(0,num):    
            num_list.append(sum(elements[j:j+i]))
    answer = len(set(num_list))    
    return answer