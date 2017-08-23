'''
Created on Aug 23, 2017

@author: anhvu
'''
from math import sqrt

def dis(x0, y0, x1, y1):
    return sqrt((x0-x1)*(x0-x1) + (y0-y1)*(y0-y1));

def area(x0, y0, x1, y1, x2, y2):
    a = dis(x0, y0, x1, y1);
    b = dis(x2, y2, x1, y1);
    c = dis(x0, y0, x2, y2);
    p = a + b + c;
    p /= 2; 
    return sqrt(p * (p-a) * (p-b) * (p-c));
n = int(input());
for test in range(n):
    data = [int(i) for i in input().split()];
    edgeCount = data[0];
    x = [];
    y = [];
    for edge in range(edgeCount):
        x.append(data[edge*2+1]);
        y.append(data[edge*2+2]);
    centerX = sum(x) / edgeCount;
    centerY = sum(y) / edgeCount;
    x.append(x[0]);
    y.append(y[0]);
    
    ret = 0;
    for edge in range(edgeCount):
        ret += area(x[edge], y[edge], x[edge+1], y[edge+1], centerX, centerY);
    print(ret);