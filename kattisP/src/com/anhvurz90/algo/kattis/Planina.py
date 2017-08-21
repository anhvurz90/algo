'''
Created on Aug 21, 2017

@author: anhvu
'''

n = int(input());

edgeLen = 2;

for i in range(n):
    edgeLen += edgeLen - 1;
    
print(pow(edgeLen, 2));