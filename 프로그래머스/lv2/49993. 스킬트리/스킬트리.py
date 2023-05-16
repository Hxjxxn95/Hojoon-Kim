def solution(skill, skill_trees):
    answer = 0

    for i in range(len(skill_trees)):
        a = True
        idx = 0
        for j in range(len(skill_trees[i])):
            if skill_trees[i][j] in skill:
                if skill_trees[i][j] == skill[idx]:
                    idx += 1
                else:
                    a = False
                    break
        if a:
            answer += 1

    return answer