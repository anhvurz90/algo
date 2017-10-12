'''
Created on Oct 12, 2017

@author: anhvu
'''
from math import cos, pi, floor, ceil

[h, v] = [int(i) for i in input().split()];
if (0 <= v) & (v <= 180):
    print("safe");
else:
    angle = v - 180;
    if (angle < 90):
        angle = 90 - angle;
    else:
        angle = angle - 90;
    ret = h / cos(angle * pi / 180);
    
    if (ceil(ret) - ret < 0.0000000000001):
        print(ceil(ret));
    else: 
        print(floor(ret));
