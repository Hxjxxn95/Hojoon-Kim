def solution(dirs):
    answer = 0
    dot_list = []
    dot = [0.0,0.0]
    for i in range(0,len(dirs)):

        if dirs[i] == 'U' and dot[1]+1 <= 5:
            if [dot[0],dot[1]+0.5] not in dot_list :
                dot_list.append([dot[0],dot[1]+0.5])
                dot[1] += 1
            else:
                dot[1] += 1
        elif dirs[i] == 'D' and dot[1]-1 >= -5:
            if [dot[0],dot[1]-0.5] not in dot_list :
                dot_list.append([dot[0],dot[1]-0.5])
                dot[1] -= 1
            else:
                dot[1] -= 1            
        elif dirs[i] == 'R'and dot[0] +1 <= 5:
            if [dot[0]+0.5,dot[1]] not in dot_list:
                dot_list.append([dot[0]+0.5,dot[1]])
                dot[0] += 1
            else:
                dot[0] += 1            
        elif dirs[i] == 'L' and dot[0] -1 >= -5:
            if [dot[0]-0.5,dot[1]] not in dot_list:
                dot_list.append([dot[0]-0.5,dot[1]])
                dot[0] -= 1
            else:
                dot[0] -= 1 
        else:
            pass

    answer = len(dot_list)
    return answer