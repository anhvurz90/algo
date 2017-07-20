'''
Created on Jul 20, 2017

@author: anhvu
'''
def checkOneDog(time, a, b):
#    print("check one dog", time, a, b);
    time = time % (a + b);
#    print("check one dog new:", time, a, b);
    ret = 1;
    if (time == 0) | (time > a):
        ret = 0;
    return ret;

def check(time, a, b, c, d):
    return checkOneDog(time, a, b) + checkOneDog(time, c, d);


dogTimes = [int(i) for i in input().split()];
a = dogTimes[0];
b = dogTimes[1];
c = dogTimes[2];
d = dogTimes[3];

manTimes = [int(i) for i in input().split()];

word = ["none", "one", "both"];

for t in manTimes:
    print(word[(check(t, a, b, c, d))]);
