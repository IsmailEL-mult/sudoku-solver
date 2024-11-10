public class DR2 extends DeductionRule {
    @Override
    public boolean apply(int[][] grid) {
        // Exemple de règle pour les colonnes
        boolean changed = false;
        for (int col = 0; col < 9; col++) {
            boolean[] used = new boolean[10];
            for (int row = 0; row < 9; row++) {
                int value = grid[row][col];
                if (value != 0) {
                    used[value] = true;
                }
            }
            for (int row = 0; row < 9; row++) {
                if (grid[row][col] == 0) {
                    int possibleValue = findUniqueInColumn(used);
                    if (possibleValue != -1) {
                        grid[row][col] = possibleValue;
                        changed = true;
                    }
                }
            }
        }
        return changed;
    }

    private int findUniqueInColumn(boolean[] used) {
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
