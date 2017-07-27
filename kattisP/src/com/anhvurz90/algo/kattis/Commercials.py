'''
Created on Jul 27, 2017

@author: anhvu
'''
pair = input().split();
n = int(pair[0]);
p = int(pair[1]);

studs = [int(i) for i in input().split()];

val0 = [0] * n;
val1 = [0] * n;

if n > 0:
    val0[0] = 0;
    val1[0] = studs[0] - p;

profit = 0;
for i in range(1, n):
    val0[i] = 0;
    val1[i] = studs[i] - p + max(val0[i-1], val1[i-1]);
    
    profit = max(profit, val1[i]);

print(profit);