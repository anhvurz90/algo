package com.anhvurz90.algo.codefights.challenge;

import java.util.Arrays;

public class ConstructSubMatrix {

  int[][] constructSubmatrix(int[][] matrix, int[] rowsToDelete, int[] columnsToDelete) {
    int row = matrix.length;
    int col = matrix[0].length;
    
    int newRow = row - rowsToDelete.length;
    int newCol = col - columnsToDelete.length;
    
    Arrays.sort(rowsToDelete);
    Arrays.sort(columnsToDelete);
    
    int[][] ret = new int[newRow][newCol];
    
    int countRow = 0;
    for (int i = 0; i < row; i++) {
      if (!contains(rowsToDelete, i)) {
        ret[countRow++] = reduce(matrix[i], columnsToDelete, newCol);
      }
    }
    
    return ret;
  }

  private int[] reduce(int[] oldRow, int[] columnsToDelete, int len) {
    int[] row = new int[len];
    int countCol = 0;
    for (int i = 0; i < oldRow.length; i++) {
      if (!contains(columnsToDelete, i)) {
        row[countCol++] = oldRow[i];
      }
    }
    return row;
  }

  private boolean contains(int[] rowsToDelete, int i) {
    for (int r : rowsToDelete) {
      if (r == i) {
        return true;
      }
    }
    return false;
  }

}
