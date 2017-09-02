'''
Created on Sep 2, 2017

@author: anhvu
'''

text = input().upper();
part = len(text) // 3;

count = 0;
for i in range(part):
    if text[i*3] != 'P':
        count+= 1;
    if text[i*3+1] != 'E':
        count+= 1;
    if text[i*3+2] != 'R':
        count+= 1;
print(count);