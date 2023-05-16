import numpy
def solution(arr1, arr2):
    answer = [[]]
    arr1 = numpy.array(arr1)
    arr2 = numpy.array(arr2)
    answer = arr1 @ arr2
    answer = answer.tolist()
    
    return answer