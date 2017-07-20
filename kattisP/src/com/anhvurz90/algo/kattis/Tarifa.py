'''
Created on Jul 19, 2017

@author: anhvu
'''
x = int(input());
n = int(input());

ret = x;
for i in range(n):
    ret += x - int(input());
    
print(ret);