import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuSolver {
    private int[][] grid = new int[9][9];  // Grille de Sudoku 9x9
    private DeductionRule[] rules = { new DR1(), new DR2(), new DR3() };

    public void loadGridFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        int row = 0;
        while (scanner.hasNextLine() && row < 9) {
            String line = scanner.nextLine();
            String[] values = line.split(",");

            for (int col = 0; col < values.length && col < 9; col++) {
                grid[row][col] = Integer.parseInt(values[col]);
            }
            row++;
        }
        scanner.close();
    }

    public void printGrid() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void solve() {
        boolean progress;
        do {
            progress = false;
            for (DeductionRule rule : rules) {
                progress |= rule.apply(grid);
            }
        } while (progress);

        if (!isSolved()) {
            System.out.println("Grille incomplète. Merci de compléter manuellement.");
        } else {
            System.out.println("Sudoku résolu !");
        }
    }

    private boolean isSolved() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) return false;
            }
        }
        return true;
    }
}
