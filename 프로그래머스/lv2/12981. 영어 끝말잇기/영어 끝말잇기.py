def solution(n, words):
    answer = [0,0]
    stack = [words[0]]
    words.pop(0)
    for word in words:
        if word not in stack and stack[-1][-1] == word[0] :
            stack.append(word)
            if word == words[-1]:
                return answer
        
        else:
            answer = [len(stack)%n+1,len(stack)//n+1]
            return answer
            
    return answer