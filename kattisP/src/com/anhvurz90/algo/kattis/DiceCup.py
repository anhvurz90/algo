st = input().split(' ');

n = int(st[0]);
m = int(st[1]);

count = [0] * (n + m);

for first in range(n):
    for second in range(m):
        count[first + second] +=1;

maxCount = max(count);

for index in range(n + m):
    if (count[index] == maxCount):
        print(index + 2);
