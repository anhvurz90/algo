'''
Created on Oct 7, 2017

@author: anhvu
'''
global moves;
global ways;
def findWay(start, way):
    global moves;
    if (len(moves[start]) == 0):
        if (way != '') & (len(way) <= 3):
            ways.add(int(way));
        if (len(way) <= 2):
            ways.add(int(way + str(start)));
        if (len(way) <= 1):
            ways.add(int(way + str(start) + str(start)));
    else:
        for next in moves[start]:
            findWay(next, way);
            findWay(next, way + str(start));
            findWay(next, way + str(start) + str(start));

moves = dict();
moves[1] = [2, 4];
moves[2] = [3, 5];
moves[3] = [6];
moves[4] = [5, 7];
moves[5] = [6, 8];
moves[6] = [9];
moves[7] = [8];
moves[8] = [9, 0];
moves[9] = [];
moves[0] = [];

ways = set();
for i in range(10):
    findWay(i, "");

ways.add(111);
ways.add(222);
#print(ways);
#print(len(ways));
testCount = int(input());
for testId in range(testCount):
    k = int(input());
    minDiff = pow(10, 6);
    ret = 0;
    for val in ways:
        if (abs(val - k) < minDiff):
            minDiff = abs(val - k);
            ret = val;
    print(ret);