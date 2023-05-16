def solution(numbers):
    answer = []
    for num in numbers:
        bit = '0' + bin(num)[2:]
        if num%2 == 0:
            bit = str(int(bit)+1)
            answer.append(int(bit,2))
        else:    
            bit = bit[:bit.rfind('0')] + '10' + bit[bit.rfind('0')+2:]
            answer.append(int(bit,2))
    return answer
