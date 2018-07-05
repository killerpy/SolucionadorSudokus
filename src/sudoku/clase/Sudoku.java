package sudoku.clase;
import java.io.*;
import java.util.*;

public class Sudoku {

	//Atributos
	
	private static int nSoluciones = 0;
	private final int DIM = 9;
	private int[][] sudoku = new int[DIM][DIM];
	
	private DataInputStream lec = null;

	//Constructor (aquí hago las llamadas a los métodos)
	
	public Sudoku() {
		cargar(sudoku);
		resolver(sudoku,0,0);
		mostrar(sudoku);
		imprimirIteraciones();
	}
	
	//Getter y setter
	
		public int[][] getSudoku(){
			return sudoku;
		}
	
	//Métodos

	private boolean comprobarFila(int valor, int fila) {
		int variable = 0;
		for(int cont = 0; cont < DIM; cont++) {
			if(sudoku[fila][cont] == valor) {
				variable++;
			}
		}
		if(variable > 0)return false;
		else return true;
	}

	private boolean comprobarColumna(int valor, int col) {
		int variable = 0;
		for(int cont = 0; cont < DIM; cont++) {
			if(sudoku[cont][col] == valor) {
				variable++;
			}
		}
		if(variable > 0) return false;
		else return true;
	}
	
	private boolean estaLleno() {
		for(int fila = 0; fila < DIM; fila++)
			for(int col = 0; col < DIM; col++)
				if(sudoku[fila][col] == 0)
					return false;
		return true;
	}
	
	public void cargar(int[][] matrix) {
		String cadena;
		try {
			lec = new DataInputStream(new FileInputStream("C:/Users/afreirea/Documents/sudoku.txt"));
			String[] partes;
			
			for(int filas = 0; filas < DIM; filas++) {
				cadena = lec.readLine();
				//System.out.println(cadena); Este es un comprobador para saber si pilla las lineas 
				partes = cadena.split(";");
				for(int columnas = 0; columnas < DIM; columnas++) 
					matrix[filas][columnas] = Integer.parseInt(partes[columnas]); 
			}
		} catch(EOFException e) {
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("Fallo de lectura");
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(lec != null) {
					lec.close();
				}
			} catch (IOException e){
				System.out.println("Error al cerrar");
			}
		}
	}
	
	public void mostrar(int [][] matrix) {
		for(int filas = 0; filas < DIM; filas++) {
			for(int columnas = 0; columnas < DIM; columnas++) 
				System.out.print(matrix [filas][columnas] + " ");
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public boolean resolver(int[][] matrix, int fila, int col) {
		nSoluciones++;
		if(estaLleno()) {
			return true;
		}

		if(matrix[fila][col] != 0) {
			if(col + 1 > 8)
				return resolver(matrix, fila+1, 0);
			else
				return resolver(matrix, fila, col+1);
		} else {

			for(int valor = 1; valor < DIM+1; valor++) {
				if(comprobarFila(valor, fila) && comprobarColumna(valor,col)) {
					matrix[fila][col] = valor;

					if(col + 1 > 8) {
						if(resolver(matrix, fila+1, 0))
							return true;
						else continue;
					} else {
						if (resolver(matrix, fila, col+1))
							return true;
						else continue;
					}
				}
			}
			matrix[fila][col] = 0;
			return false;
		}
	}
	
	public void imprimirIteraciones() {
		System.out.println("Se han probado: " + nSoluciones + " combinaciones");
	}
	
}