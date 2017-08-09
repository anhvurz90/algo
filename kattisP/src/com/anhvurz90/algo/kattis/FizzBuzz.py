'''
Created on Aug 9, 2017

@author: anhvu
'''

triple = [int(i) for i in input().split()];
x = triple[0];
y = triple[1];
n = triple[2];
for i in range(1, n+1):
    if (i % x == 0) & (i % y == 0):
        print("FizzBuzz");
    elif (i % x == 0):
        print("Fizz");
    elif (i % y == 0):
        print("Buzz");
    else:
        print(i);
