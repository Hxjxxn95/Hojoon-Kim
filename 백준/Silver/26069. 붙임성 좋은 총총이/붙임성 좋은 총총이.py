dance = {'ChongChong':1}
N = int(input())
for i in range(N):
    a = input().split()
    for j in range(2):
        if a[j] in dance:
            dance[a[j-1]] = 1
            break
answer = list(dance.values()).count(1)
print(answer)