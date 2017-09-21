'''
Created on Sep 21, 2017

@author: anhvu
'''

n = int(input());
if n < 2:
    print(0);
else:
    print(pow(2, n) - 1 - n);