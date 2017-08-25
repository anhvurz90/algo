'''
Created on Aug 25, 2017

@author: anhvu
'''

pair = [int(i) for i in input().split()];
n = pair[0];
p = pair[1];

time = [int(i) for i in input().split()];

pTime = time[p];

time.remove(pTime);
time.sort();
time1 = [pTime];
time1.extend(time);

penalty = 0;
currentTime = 0;
count = 0;

for t in time1:
    if (currentTime + t <= 300):
        count += 1;
        currentTime += t;
        penalty += currentTime;
    else:
        break;
        
print(count, penalty);