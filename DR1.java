public class DR1 extends DeductionRule {
    @Override
    public boolean apply(int[][] grid) {
        // Exemple simple : vérifier les valeurs uniques dans chaque ligne
        boolean changed = false;
        for (int row = 0; row < 9; row++) {
            boolean[] used = new boolean[10];
            for (int col = 0; col < 9; col++) {
                int value = grid[row][col];
                if (value != 0) {
                    used[value] = true;
                }
            }
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    int possibleValue = findUniqueInRow(used);
                    if (possibleValue != -1) {
                        grid[row][col] = possibleValue;
                        changed = true;
                    }
                }
            }
        }
        return changed;
    }

    private int findUniqueInRow(boolean[] used) {
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
