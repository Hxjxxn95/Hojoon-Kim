import math
def convert(time):
    answer = int(time[0:2])*60 + int(time[3:5])
    return answer

def solution(fees, records):
    answer = []
    car_table = {}
    time_list = []
    for car in records:
        if car[6:10] not in car_table:
            car_table[car[6:10]] = [car[0:5],car[11:],0]
        else : 
            if car[11:] == 'OUT':
                car_table[car[6:10]] = [car[0:5],car[11:],convert(car[0:5])-convert(car_table[car[6:10]][0])+car_table[car[6:10]][2]]
            else : 
                car_table[car[6:10]] = [car[0:5],car[11:],car_table[car[6:10]][2]]
    for i in car_table.keys():
        if car_table[i][1] == 'IN' :
            car_table[i][1] = 'OUT'
            car_table[i][2] = (convert("23:59")-convert(car_table[i][0])) +car_table[i][2]
    car_table = dict(sorted(car_table.items()))
    for i in car_table.keys():
        time_list.append(car_table[i][2])
    
    for time in time_list : 
        if time <= fees[0]:
            answer.append(fees[1])
        else:
            answer.append(fees[1]+math.ceil((time-fees[0])/fees[2])*fees[3])
    
    return answer