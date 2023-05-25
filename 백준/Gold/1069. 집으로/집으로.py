import math

X,Y,D,T=map(int,input().split())

L=math.sqrt(X**2+Y**2)

if L>=D:
    jump=L//D
    print("%.10f"%min(L,jump*T+L-(jump*D),(jump+1)*T))
else:
    print("%.10f"%min(L,T+D-L,2*T))