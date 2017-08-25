'''
Created on Aug 25, 2017

@author: anhvu
'''

c = float(input());
l = int(input());

sum = 0;
for line in range(l):
    pair = [float(num) for num in input().split()];
    sum += pair[0] * pair[1];

print(sum * c);