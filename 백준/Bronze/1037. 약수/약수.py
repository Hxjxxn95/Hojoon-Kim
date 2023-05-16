N  = int(input())
N_list = list(map(int,input().split()))
N_list = sorted(N_list)
print(N_list[0]*N_list[-1])