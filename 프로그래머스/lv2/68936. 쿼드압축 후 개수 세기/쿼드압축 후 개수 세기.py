def solution(arr):
    answer = [0,0]
    n = len(arr)
    def quad(i,j,n):
        a = arr[i][j]
        for x in range(i,i+n):
            for y in range(j,j+n):
                if arr[x][y] != a:
                    n//=2
                    quad(i,j,n)
                    quad(i,j+n,n)
                    quad(i+n,j,n)
                    quad(i+n,j+n,n)
                    return
                
        answer[a] += 1 
    quad(0,0,n)
    return answer