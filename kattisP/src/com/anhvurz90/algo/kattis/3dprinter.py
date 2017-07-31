'''
Created on Jul 31, 2017

@author: anhvu
'''

n = int(input());

p = 0;
while (pow(2, p)< n):
    p+= 1;

print(p + 1);