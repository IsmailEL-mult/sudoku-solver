import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();
        try {
            solver.loadGridFromFile("sudoku.txt");
            System.out.println("Grille de Sudoku initiale :");
            solver.printGrid();

            solver.solve();

            System.out.println("Grille de Sudoku après résolution :");
            solver.printGrid();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier sudoku.txt est introuvable.");
        }
    }
}
