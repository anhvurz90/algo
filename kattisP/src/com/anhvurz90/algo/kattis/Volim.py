'''
Created on Jul 20, 2017

@author: anhvu
'''

k = int(input());
n = int(input());
currentTime = 0;
for i in range(n):
    timeAnswer = input().split(" ");
    time = int(timeAnswer[0]);
    answer = timeAnswer[1];
    if (currentTime + time >= 210):
        print(k);
        break;
    
    currentTime += time;
    if (answer == "T"):
        k = (k % 8) + 1;
