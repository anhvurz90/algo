'''
Created on Aug 20, 2017

@author: anhvu
'''

t = int(input());
for test in range (t):
    n = int(input());
    s = set();
    for i in range(n):
        s.add(input());
    print(len(s));
