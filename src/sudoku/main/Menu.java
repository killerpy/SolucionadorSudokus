package sudoku.main;
import java.util.Scanner;
import sudoku.clase.Sudoku;

public class Menu {

	Scanner sc = new Scanner(System.in);	
	
	//Constructor (Menú)
	
	public Menu() {
		Sudoku sudokuPrueba = new Sudoku();
		int[][] matriz = sudokuPrueba.getSudoku();
		System.out.println("Este es tu sudoku:\n");
		sudokuPrueba.cargar(matriz);
		sudokuPrueba.mostrar(matriz);
		String variable;
		do {
			System.out.println("Escribe 'SI' para resolver o 'NO' para finalizar:");
			variable = sc.nextLine();
		} while((!variable.equalsIgnoreCase("SI")) && (!variable.equalsIgnoreCase("NO")));
		if(variable.equalsIgnoreCase("SI")) {
			sudokuPrueba.resolver(matriz,0,0);
			System.out.println("\nEsta es su solución:\n");
			sudokuPrueba.mostrar(matriz);
		} else if(variable.equalsIgnoreCase("NO")) {
			sudokuPrueba.resolver(matriz,0,0);
			System.out.println("FIN");
		}
		
		if(variable.equalsIgnoreCase("SI")) {
			do {
				System.out.println("Imprimir el número de combinaciones probadas? 'SI/NO':");
				variable = sc.nextLine();
			} while((!variable.equalsIgnoreCase("SI")) && (!variable.equalsIgnoreCase("NO")));
			if(variable.equalsIgnoreCase("SI")) {
				sudokuPrueba.imprimirIteraciones();
				System.out.println("FIN");
			}else if(variable.equalsIgnoreCase("NO")) {
				sudokuPrueba.resolver(matriz,0,0);
				System.out.println("FIN");
			}
		} 
	}

	//Métodos del menú
	
	public String introducirDatos() {
		String cadena = sc.nextLine();
		return cadena;
	}
	
	//Main
	
	public static void main(String[] args) {
		Menu interfaz = new Menu();
	}
	
}