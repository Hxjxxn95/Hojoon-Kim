def solution(brown, yellow):
    answer = []
    divisorsList = []

    for i in range(1, int(yellow**(1/2)) + 1):
        if (yellow % i == 0):
            divisorsList.append(i) 
            if ( (i**2) != yellow) : 
                divisorsList.append(yellow // i)
    for x in divisorsList:
        if 2*x + 2*(yellow//x)+4 == brown :
            answer = [x+2,(yellow//x)+2]
    return answer