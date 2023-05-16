def solution(number, k):
    number = list(map(int,number))
    cnt = 0
    answer = ''
    stack =[]
    for i in range(len(number)):
        try:
            while stack[-1] < number[i] and cnt < k:
                cnt += 1
                stack.pop()
        except:
            pass
        stack.append(number[i])

        if cnt == k:
            answer = ''.join(map(str,stack + number[i+1:]))
            return answer
    answer = ''.join(map(str,stack[:len(number)-k]))                
    return answer