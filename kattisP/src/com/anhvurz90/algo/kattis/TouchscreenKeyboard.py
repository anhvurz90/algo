'''
Created on Aug 6, 2017

@author: anhvu
'''
from functools import cmp_to_key;

global dis;
global ordA;

def comparator(a, b):
#    print(a, b);
    if a[1] < b[1]:
        return -1;
    if a[1] > b[1]:
        return 1;
    if a[0] < b[0]:
        return -1;
    if a[0] > b[0]:
        return 1;

def distance(s1, s2):
    global dis;
    global ordA;
    count = 0;
    for i in range(len(s1)):
        count += dis[ord(s1[i]) - ordA][ord(s2[i]) - ordA];
    return count;

kb = [];
kb.append('qwertyuiop');
kb.append('asdfghjkl');
kb.append('zxcvbnm');

dis = [[0 for x in range(26)] for y in range(26)];
ordA = ord('a');

for x in range(len(kb)):
    for y in range(len(kb[x])):
        for a in range(len(kb)):
            for b in range(len(kb[a])):
                dis[ord(kb[x][y])-ordA][ord(kb[a][b])-ordA] = abs(x-a) + abs(y-b);

#for r in dis:
#    print(r);
#print(ord('z')-ord('a'));
n = int(input());
for test in range(n):
    pair = input().split();
    word = pair[0];
    sample_count = int(pair[1]);
    samples = [];
    for a in range(sample_count):
        s = input();
        samples.append((s, distance(s, word)));
        
    samples.sort(key = cmp_to_key(comparator));
    for s in samples:
        print(s[0], s[1]);
