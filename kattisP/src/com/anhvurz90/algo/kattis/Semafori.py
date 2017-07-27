'''
Created on Jul 27, 2017

@author: anhvu
'''

pair = input().split();
n = int(pair[0]);
l = int(pair[1]);

prev = 0;
time = 0;
for i in range(n):
    triple = input().split();
    d = int(triple[0]);
    r = int(triple[1]);
    g = int(triple[2]);
    
    leng = d - prev;
    time += leng;
    
    modulo = time % (r + g);
    if (modulo < r):
        time = time - modulo + r;
    
    prev = d;
print(time + l - d); 
