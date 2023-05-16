def convert(n, k):   # n을 k 진수로 변환
    arr = []
    while n!= 0:
        r = n%k
        n = n//k
        arr.append(r)
    return ''.join(list(map(str,arr[::-1])))

def is_prime_number(n):
    if n <= 1: return False
    i = 2
    while i*i <= n:
        if n%i == 0: return False
        i += 1
    return True
    
def solution(n, k):
    answer = 0
    sosu = convert(n,k)    
    sosu_list = sosu.split('0')
    print(sosu_list)

    for i in range(len(sosu_list)):
        if sosu_list[i] == '' or sosu_list[i] == ' ':
            pass
        elif  sosu_list[i] != '1' and sosu_list[i] != '0' and is_prime_number(int(sosu_list[i])) :
            answer+=1
    return answer