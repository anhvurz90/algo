'''
Created on Aug 26, 2017

@author: anhvu
'''

from math import sin, pi, ceil
pair = [int(i) for i in input().split()];
print(ceil(pair[0] / sin(pair[1]/180*pi)));

