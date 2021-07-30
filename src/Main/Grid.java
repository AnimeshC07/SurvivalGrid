package Main;

import java.util.Scanner;

// A simple Java program to implement Game of Life
public class Grid {
	public static void main(String[] args) {
		int M = 10, N = 10;
		int id = 1;
		int row = 0, col = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Throughout this program whenever we'll display the grid in the screen"
				+ " we'll be representing \ndead cells as (.) and alive as (*) for better understanding"
				+ " & cleanliness in the output screen. ");

		Cell[][] grid = new Cell[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = new Cell(id++, 0);
			}
		}

		do {
			System.out.println("\n\n\nPlease select your operation from the list:--> \n");
			System.out.println("1) change the current generation\n");
			System.out.println("2) display the current generation\n");
			System.out.println("3) find the status of a cell\n");
			System.out.println("4) Exit\n");
			int ans = sc.nextInt();
			switch (ans) {
			case 1:

				System.out.println("Current Generation");
				displayGrid(grid, M, N);

				System.out.println("Enter the number of poition you want to change the status to alive : ");
				int noFcell = sc.nextInt();

				for (int i = 0; i < noFcell; i++) {
					System.out.println("Enter the position you want to change ");
					int pos = sc.nextInt();
					if (pos > 0 && pos <= 100) {
						row = calculateRowPosition(pos);
						col = calculateColPosition(pos);
						grid[row][col].setStatus(1);
					} else {
						System.out.println("please give input for the specified range [1-100]");
						continue;
					}
				}

				// Processing next generation
				futureGeneration(grid, M, N);

				System.out.println("Next Generation");
				displayGrid(grid, M, N);

				break;

			case 2:

				System.out.println("Current Generation");
				displayGrid(grid, M, N);

				break;

			case 3:

				System.out.println("Please enter the cell whose status you want :--> ");
				int Cpos = sc.nextInt();
				if (Cpos > 0 && Cpos <= 100) {
					findStatusById(grid, Cpos);
				} else {
					System.out.println("please give input for the specified range [1-100]");
				}

				break;

			case 4:

				System.out.println(" Are you sure you want to exit(y/n) ");
				String ch = sc.next();

				if (ch.charAt(0) == 'y' || ch.charAt(0) == 'Y')
					System.exit(0);
				else
					continue;

				break;
			default:
				System.out.println("Invalid selection. Please try again");
				break;
			}
		} while (true);

	}

	private static int calculateRowPosition(int pos) {
		// TODO Auto-generated method stub
		int row = 0;

		if (pos % 10 != 0)
			row = pos / 10;
		else if (pos % 10 == 0)
			row = (pos / 10) - 1;
		return row;

	}

	private static int calculateColPosition(int pos) {
		// TODO Auto-generated method stub
		int col = 0;

		if (pos % 10 != 0)
			col = (pos % 10) - 1;
		else if (pos % 10 == 0)
			col = 9;
		return col;
	}

	// function to provide status for a given input cell
	static void findStatusById(Cell grid[][], int Cpos) {
		// TODO Auto-generated method stub

		int row = 0, col = 0;

		row = calculateRowPosition(Cpos);
		col = calculateColPosition(Cpos);

		System.out.println("The status for " + grid[row][col].getId() + " Is :--> "
				+ (grid[row][col].getStatus() == 1 ? "Alive" : "Dead"));
	}

	// function to display the grid
	static void displayGrid(Cell grid[][], int M, int N) {

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// dead cells are marked with .
				if (grid[i][j].getStatus() == 0)
					System.out.print(".");
				else
					System.out.print("*"); // alive are marked with *
			}
			System.out.println();
		}

	}

	// function to process next generation
	static void futureGeneration(Cell grid[][], int M, int N) {
		int[][] future = new int[M][N];

		for (int l = 1; l < M - 1; l++) {
			for (int m = 1; m < N - 1; m++) {
				int aliveCells = 0;
				// calculating neighboring alive cells for a given cell
				for (int i = -1; i <= 1; i++)
					for (int j = -1; j <= 1; j++)
						aliveCells += grid[l + i][m + j].getStatus();

				// subtracting the current cell as it should not be calculated
				aliveCells -= grid[l][m].getStatus();

				// dies due to loneliness
				if ((grid[l][m].getStatus() == 1) && (aliveCells < 2))
					future[l][m] = 0;

				// dies due to overcrowding
				else if ((grid[l][m].getStatus() == 1) && (aliveCells > 3))
					future[l][m] = 0;

				// gets alive
				else if ((grid[l][m].getStatus() == 0) && (aliveCells == 3))
					future[l][m] = 1;

				// nothing changes
				else
					future[l][m] = grid[l][m].getStatus();
			}
		}

		// updating the grid
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j].setStatus(future[i][j]);
			}
		}

	}
}
