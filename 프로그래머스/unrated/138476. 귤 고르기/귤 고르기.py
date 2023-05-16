def solution(k, tangerine):
    answer = 0
    check = 0
    tangerine.sort()
    count_table = {}
    for i in tangerine:
        if i in count_table:
            count_table[i] += 1
        else:
            count_table[i] = 1

    arr = sorted(count_table.items(), key=lambda x: x[1], reverse=True)
    if arr[0][1] >= k:
        return 1
    else:
        for i in arr:
            if check < k:
                check += i[1]
                answer += 1
            else:
                break
    return answer