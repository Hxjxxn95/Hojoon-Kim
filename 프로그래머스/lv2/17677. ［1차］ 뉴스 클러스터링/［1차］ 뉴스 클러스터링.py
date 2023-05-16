def solution(str1, str2):
    answer = 0

    str1_list = []
    str2_list = []
    list_12 = []
    str1 = str1.lower()
    str2 = str2.lower()
    for i in range(len(str1)-1):
        if str1[i:i+2].isalpha() :
            str1_list.append(str1[i:i+2])
    for i in range(len(str2)-1):
        if str2[i:i+2].isalpha()  :
            str2_list.append(str2[i:i+2])
    str2_temp = str2_list.copy()
    for i in range(len(str1_list)):
        if str1_list[i] in str2_temp :
            list_12.append(str1_list[i])
            str2_temp.remove(str1_list[i])
            
    if len(str1_list)+len(str2_list)-len(list_12) == 0:
        return 65536
    answer = int(65536*len(list_12)/(len(str1_list)+len(str2_list)-len(list_12)))
    print(str1_list,str2_list,list_12)
    return answer