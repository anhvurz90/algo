'''
Created on Sep 26, 2017

@author: anhvu
'''
n = int(input());
for i in range(n):
    babylonianNum = input();
    sum = 0;
    position = 0;
    for digit in reversed(babylonianNum.split(",")):
        if (len(digit) > 0):
            sum+= pow(60, position) * int(digit);
        position += 1;
    print(sum);