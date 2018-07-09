package sudoku.main;
import java.util.Scanner;
import sudoku.clase.Sudoku;

public class Menu {

	Scanner sc = new Scanner(System.in);	
	
	public Menu() {
		Sudoku sudokuPrueba = new Sudoku();
		int[][] matriz = sudokuPrueba.getSudoku();
		System.out.println("Este es tu sudoku:\n");
		sudokuPrueba.cargar(matriz);
		sudokuPrueba.mostrar(matriz);
		String variable;
		do {
			System.out.println("Escribe 'SI' para resolver o 'NO' para finalizar:");
			variable = sc.next();
		} while((!variable.equalsIgnoreCase("SI")) && (!variable.equalsIgnoreCase("NO")));
		if(variable.equalsIgnoreCase("SI")) {
			sudokuPrueba.resolver(matriz,0,0);
			System.out.println("\nEsta es su solución:\n");
			sudokuPrueba.mostrar(matriz);
		} 
		
		if(variable.equalsIgnoreCase("SI")) {
			do {
				System.out.println("Imprimir el número de combinaciones probadas? 'SI/NO':");
				variable = sc.next();
			} while((!variable.equalsIgnoreCase("SI")) && (!variable.equalsIgnoreCase("NO")));
			if(variable.equalsIgnoreCase("SI")) {
				sudokuPrueba.imprimirIteraciones();
			}
		} 
	}
	
	public static void main(String[] args) {
		Menu interfaz = new Menu();
	}
	
	public String introducirDatos() {
		String cadena = sc.nextLine();
		return cadena;
	}
	
}
