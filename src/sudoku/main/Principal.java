package sudoku.main;
import sudoku.clase.Sudoku;

public class Principal {

	public Principal() {
		Sudoku sudokuPrueba = new Sudoku();
		int[][] matriz = sudokuPrueba.getSudoku();
		sudokuPrueba.cargar(matriz);
		sudokuPrueba.resolver(matriz,0,0);
		sudokuPrueba.mostrar(matriz);
		sudokuPrueba.imprimirIteraciones();
	}
	
	public static void main(String[] args) {
		Principal interfaz = new Principal();
	}

}
