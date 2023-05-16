def solution(cacheSize, cities):
    answer = 0
    cache = []
    for city in cities:
        city = city.lower()
        if cacheSize == 0:
            answer =  len(cities) * 5
            return answer
        if city not in cache:
            if len(cache) == cacheSize :
                try:
                    cache.remove(cache[0])
                except:
                    pass
                cache.append(city)
                answer+=5 
            else:
                cache.append(city)
                answer+=5
        else:
            cache.remove(city)
            cache.append(city)
            answer+=1
            
        
    return answer
