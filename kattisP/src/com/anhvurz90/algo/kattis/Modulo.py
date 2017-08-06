'''
Created on Aug 6, 2017

@author: anhvu
'''
modulo = set();

for i in range(10):
    modulo.add(int(input()) % 42);

print(len(modulo));