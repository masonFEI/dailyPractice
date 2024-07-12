/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

import java.util.HashMap;
import java.util.Map;

/**
 * ModifiedMatrix
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-07-05 17:17
 */
public class ModifiedMatrix {


    public int[][] modifiedMatrix(int[][] matrix) {

        Map<Integer, Integer> maxMap = new HashMap<Integer, Integer>();

        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {

                if (!maxMap.containsKey(j)) {
                    maxMap.put(j, ints[j]);
                } else {
                    maxMap.put(j, Math.max(maxMap.get(j), ints[j]));
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = maxMap.get(j);
                }
            }
        }

        return matrix;

    }


}