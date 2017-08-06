'''
Created on Aug 6, 2017

@author: anhvu
'''

s = [];
m = 0;
pos = 0;
for i in range(5):
    grade = [int(a) for a in input().split()];
    cs = sum(grade);
    if (cs > m):
        m = cs;
        pos = i;
        
print(pos + 1, m);