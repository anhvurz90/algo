moves = input();
val = [1, 0, 0];
for m in moves:
    first = 0;
    second = 1;
    if (m == 'B'):
        first = 2;
    elif (m == 'C'):
        second = 2;
        
    tmp = val[first];
    val[first] = val[second];
    val[second] = tmp;

print(val.index(1) + 1);
