package com.anhvurz90.algo.codefights.challenge;

public class BugBGone {
  
  int bugBGone(int[][] area) {
    int len = area.length;
    return countSpray(area, 0, 0, len, len);
  }
  
  private int countSpray(int[][] area, int topX, int topY, int botX, int botY) {
      if (topX == botX) {
          return 1;
      } else {
          int sum = sumVal(area, topX, topY, botX, botY);
          return sum <= 1? 1 : 
          countSpray(area, topX, topY, (topX + botX) / 2, (topY + botY) / 2) +
          countSpray(area, topX, (topY + botY) / 2, (topX + botX) / 2, botY) +
          countSpray(area, (topX + botX) / 2, topY, botX, (topY + botY) / 2) +
          countSpray(area, (topX + botX) / 2, (topY + botY) / 2, botX, botY);
      }
  }
  
  private int sumVal(int[][] area, int topX, int topY, int botX, int botY) {
      int ret = 0;
      for (int a = topX; a < botX; a++) {
          for (int b = topY; b < botY; b++) {
              ret+= area[a][b];
          }
      }
      return ret;
  }

}
