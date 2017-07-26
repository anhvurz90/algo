'''
Created on Jul 26, 2017

@author: anhvu
'''

r = 1;
c = 1;
while (r != 0) | (c != 0):
    pair = input().split();
    r = int(pair[0]);
    c = int(pair[1]);
    
    if (r == 0) & (c == 0):
        break;
    lis = [];
    for i in range(c):
        lis.append("");
    
    for i in range(r):
        st = input();
        for j in range(len(st)):
            lis[j] += st[j];
    
    lis = sorted(lis, key=lambda s: s.lower());
    
    ret = [];
    for i in range(r):
        ret.append("");
    
    for j in range(c):
        for i in range(r):
            ret[i] += lis[j][i];
    
    for i in range(r):
        print(ret[i]);
        
    print();
        