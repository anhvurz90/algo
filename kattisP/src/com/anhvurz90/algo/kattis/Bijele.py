from functools import reduce

st = input().split(" ");
correct = [1, 1, 2, 2, 2, 8];
val = [int(i) for i in st];
for i in range (len(st)):
    val[i] = correct[i] - val[i];
     
print(reduce((lambda x, y: str(x) + " " + str(y)), val));
