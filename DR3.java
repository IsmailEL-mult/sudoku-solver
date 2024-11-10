public class DR3 extends DeductionRule {
    @Override
    public boolean apply(int[][] grid) {
        // Exemple de règle pour les sous-grilles (3x3)
        boolean changed = false;
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                boolean[] used = new boolean[10];
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        int value = grid[boxRow * 3 + row][boxCol * 3 + col];
                        if (value != 0) {
                            used[value] = true;
                        }
                    }
                }
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        if (grid[boxRow * 3 + row][boxCol * 3 + col] == 0) {
                            int possibleValue = findUniqueInBox(used);
                            if (possibleValue != -1) {
                                grid[boxRow * 3 + row][boxCol * 3 + col] = possibleValue;
                                changed = true;
                            }
                        }
                    }
                }
            }
        }
        return changed;
    }

    private int findUniqueInBox(boolean[] used) {
        int possible = -1;
        for (int num = 1; num <= 9; num++) {
            if (!used[num]) {
                if (possible == -1) {
                    possible = num;
                } else {
                    return -1;
                }
            }
        }
        return possible;
    }
}
