package leetcode.solution.hard._0827;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int largestIsland(int[][] grid) {
        int value = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int a = area(grid, r, c, value);
                    map.put(value, a);
                    value++;
                }
            }
        }
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                int ta = thisArea(grid, r, c, map);
                res = Math.max(res, ta);
            }
        }
        return res;
    }

    private int thisArea(int[][] grid, int r, int c, Map<Integer, Integer> map) {
        if (grid[r][c] != 0) return map.get(grid[r][c]);
        int res = 0;
        Set<Integer> adjs = new HashSet<>();
        if (inArea(grid, r - 1, c) && grid[r - 1][c] > 0) {
            adjs.add(grid[r - 1][c]);
        }
        if (inArea(grid, r + 1, c) && grid[r + 1][c] > 0) {
            adjs.add(grid[r + 1][c]);
        }
        if (inArea(grid, r, c - 1) && grid[r][c - 1] > 0) {
            adjs.add(grid[r][c - 1]);
        }
        if (inArea(grid, r, c + 1) && grid[r][c + 1] > 0) {
            adjs.add(grid[r][c + 1]);
        }
        for (int adj : adjs) {
//            System.out.println();
            res += map.get(adj);
        }
        return res + 1;
    }

    private int area(int[][] grid, int r, int c, int value) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = value;

        return 1 + area(grid, r - 1, c, value)
                + area(grid, r + 1, c, value)
                + area(grid, r, c - 1, value)
                + area(grid, r, c + 1, value);
    }

    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }
}
