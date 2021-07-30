SURVIVAL GRID :--

A two-dimensional orthogonal grid of square cells, each of which is in one of two
possible states, live or dead. Every cell interacts with its eight neighbors, which are the cells that are
directly horizontally, vertically, or diagonally adjacent.

RULES :--

1. Any live cell with fewer than two live neighbors dies, as if by loneliness.
2. Any live cell with more than three live neighbors dies, as if by overcrowding.
3. Any live cell with two or three live neighbors lives, unchanged, to the next generation.
4. Any dead cell with exactly three live neighbors comes to life.

The initial pattern constitutes the 'seed' (randomly placed 500 cells) of the system. The first generation is
created by applying the above rules simultaneously to every cell in the seed — births and deaths happen
simultaneously, and the discrete moment at which this happens is called a tick. (In other words, each
generation is a pure function of the one before.)

FUNCTIONALITIES :--

A 4 option menu is provided as the main screen :

1) To make the changes in the current grid :--
	
	User will be asked about how many places they would like to make the changes. Then they'll be asked
	to input the position they would like to make the cells alive.
	According to the input the existing grid would be changed and the next generation changes would be 
	calculated and displayed.

2) To display the current grid :--
	
	This option will display the current grid stored.
	
3) To display the status for a particular cell number.

	The user will have to enter a cell number from the range [1-100] for which they'll like to see the
	status. The program will fetch the input , calculate the position and will display it's status.
	
4) Exit

	This is used to exit from the program altogether after taking the confirmation from the user.


NOTE: The grid is displayed in a format as "." represents a dead cell and a " * " represents an active cell.
	  This has been implemented to make the output screen clear and easy to understand.