'''
Created on Aug 13, 2017

@author: anhvu
'''
pair = input().split();
a = pair[0][::-1];
b = pair[1][::-1];
print(max(a, b));