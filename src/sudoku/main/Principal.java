package sudoku.main;
import sudoku.clase.Sudoku;

public class Principal {

	public Principal() {
		
		Sudoku prueba = new Sudoku();
		cargar(sudoku);
		resolver(sudoku,0,0);
		mostrar(sudoku);
		imprimirIteraciones();
	
	}
	
	public static void main(String[] args) {
		Principal interfaz = new Principal();
	}

}
