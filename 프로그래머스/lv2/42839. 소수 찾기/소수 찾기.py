import itertools
import math
from functools import reduce
def is_prime_number(x):
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return 0
    return 1
def solution(numbers):
    answer = 0
    num_list = set()
    for i in range(1,len(numbers)+1):
        for j in list(itertools.permutations(list(numbers),i)):
            num_list.add(int(reduce(lambda x ,y: x+y ,j)))
    if 0 in num_list:
        num_list.remove(0)
    if 1 in num_list:
        num_list.remove(1)
    for i in num_list:
        answer += is_prime_number(i)
    return answer