'''
Created on Oct 16, 2017

@author: anhvu
'''
def lcd(a, b):
    while (a % b != 0):
        c = a % b;
        a = b;
        b = c;
    return b;

machineCount = int(input());
for machineId in range (machineCount):
    wheelCount = int(input());
    wheels = [int(i) for i in input().split()];
    ret = wheels[0];
    for wheel in wheels:
        ret = ret * wheel // lcd(ret, wheel);
        if (ret > pow(10, 9)):
            break;
    
    if (ret > pow(10, 9)):
        print("More than a billion.");
    else:
        print(ret);
    
    