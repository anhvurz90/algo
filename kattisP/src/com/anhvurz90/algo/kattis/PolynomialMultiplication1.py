'''
Created on Jul 27, 2017

@author: anhvu
'''
#import sys
#print(sys.maxsize);
t = int(input());

for i in range(t):
    n1 = int(input());
    p1 = [int(a) for a in input().split()];
    n2 = int(input());
    p2 = [int(a) for a in input().split()];
    
    ret = [0] * (n1 + n2 + 1);
    for x in range(n1+1):
        for y in range(n2+1):
            ret[x + y] += p1[x] * p2[y];
    
    st = str(ret[0]);
    for idx in range(1, n1 + n2 + 1):
        st += " " + str(ret[idx]);
    print(n1 + n2);
    print(st);
