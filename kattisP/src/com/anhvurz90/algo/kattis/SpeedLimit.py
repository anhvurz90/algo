n = 0;
while n != -1:
    n = int(input());
    if (n != -1):
        speedTime = [[0, 0]];
        ret = 0;
        for index in range(n):
            pair = [int(val) for val in input().split(" ")];
            speedTime.append(pair);
            ret += speedTime[index+1][0] * (speedTime[index+1][1] - speedTime[index][1]);
        print(str(ret) + " miles");
