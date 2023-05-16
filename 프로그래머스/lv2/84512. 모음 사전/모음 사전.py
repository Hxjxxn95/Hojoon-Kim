from itertools import product

def solution(word):
    answer = 0
    table = []
    alpha = ['A','E', 'I', 'O','U' ]
    for i in range(1,6):
        table += [''.join(x) for x in product(alpha,repeat = i)]
    table = sorted(table)
    answer = table.index(word) + 1           
        
    return answer