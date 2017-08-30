'''
Created on Aug 30, 2017

@author: anhvu
'''

testNum = int(input());

for test in range(testNum):
    turtles = [int(i) for i in input().split()];
    
    immigrants = 0;
    for idx in range(1, len(turtles)):
        if (turtles[idx] > 0) & (turtles[idx] > 2 * turtles[idx-1]):
            immigrants+= (turtles[idx] - 2 * turtles[idx-1]);
    
    print(immigrants);