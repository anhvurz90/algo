'''
Created on Oct 13, 2017

@author: anhvu
'''
test = int(input());
for testId in range(test):
    customers = int(input());
    sums = [];
    for customerId in range(customers):
        woods = [int(i) for i in input().split()];
        s = sum(woods) - woods[0];
        sums.append(s);
    sums = sorted(sums);
    
    wait = [sums[0]];
    total = sums[0];
    for waitId in range(1, len(sums)):
        wait.append(wait[waitId -1] + sums[waitId]);
        total+= wait[waitId];
    print(total/ len(sums)); 