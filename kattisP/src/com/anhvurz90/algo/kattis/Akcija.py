'''
Created on Aug 5, 2017

@author: anhvu
'''

n = int(input());
l = [];
s = 0;
count = 0;
for i in range(n):
    val = int(input());
    l.append(val);
    s += val;
    
l.sort(reverse=True);
for i in range(len(l)):
    if (i % 3 == 2):
        s -= l[i];

print(s);