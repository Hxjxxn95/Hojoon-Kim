def convert_notation(n, base):
    T = "0123456789ABCDEF"
    q, r = divmod(n, base)

    return convert_notation(q, base) + T[r] if q else T[r]

def solution(n, t, m, p):
    answer = ''
    n_word = ''
    for i in range(m*t):
        n_word += convert_notation(i,n)
    for i in range(p-1,p-1 + m*t,m):
        answer += n_word[i]
    
    return answer