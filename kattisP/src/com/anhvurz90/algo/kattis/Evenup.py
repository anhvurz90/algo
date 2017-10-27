'''
Created on Oct 27, 2017

@author: anhvu
'''
n = int(input());
stack = [];
for num in input().split():
    val = int(num);
    if (len(stack) == 0):
        stack.append(val);
    else:
        if ((stack[len(stack) - 1] + val) % 2 == 0):
            stack.pop();
        else:
            stack.append(val);
print(len(stack));