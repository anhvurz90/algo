'''
Created on Sep 3, 2017

@author: anhvu
'''
while (True):
    pair = [int(i) for i in input().split()];
    if (pair[0] == 0 & pair[1] == 0):
        break;
    whole = pair[0] // pair[1];
    print(whole, pair[0] % pair[1], "/", pair[1]);
    