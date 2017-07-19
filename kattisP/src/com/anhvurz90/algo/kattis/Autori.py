from functools import reduce

st = input();
ret = [c for c in st if (ord("A") <= ord(c)) & (ord(c) <= ord('Z'))];
print(reduce((lambda x, y: x + y), ret));