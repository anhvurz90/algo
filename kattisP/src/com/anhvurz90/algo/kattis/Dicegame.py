'''
Created on Aug 28, 2017

@author: anhvu
'''

def average(a, b):
    return (a + b); 

gDices = [int(i) for i in input().split()];
eDices = [int(i) for i in input().split()];

gVal = average(gDices[0], gDices[1]) + average(gDices[2], gDices[3]);
eVal = average(eDices[0], eDices[1]) + average(eDices[2], eDices[3]);

if abs(gVal - eVal) < 0.000001:
    print("Tie");
elif gVal > eVal:
    print("Gunnar");
else:
    print("Emma");