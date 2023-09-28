import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Integer nums;


    public SudokuSolver(String fileName) {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName))) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {
                        number = 0;
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }

        rows = new ArrayList<> ();

        cols= new ArrayList<> ();
        squares= new ArrayList<> ();

        // create the list of sets for each row (this.rows)
        
        
        // [0, 1, 2, 3, 4, 5]
        // list[0]
        // 
        // [ [ . ], [ . ], [ . ]]
        // for for

        this.rows = new ArrayList<Set<Integer>>();


        for(int count = 0; count<grid.length; count++){
            
                Set<Integer> currrows = new HashSet<>();

                for(int j = 0; j<grid[0].length; j++){
                currrows.add(grid[count][j]);}

                
            this.rows.add(currrows);
        }
        
   
        //System.out.println(rows);
        

        // create the list of sets for each col (this.cols)
        this.cols = new ArrayList<Set<Integer>>();


        for(int count = 0; count<grid[0].length; count++){
            
                Set<Integer> curr = new HashSet<>();

                for(int j = 0; j<grid.length; j++){
                curr.add(grid[j][count]);}

                
            this.cols.add(curr);
        }
        
        //System.out.println(cols);


        // create the list of sets for each square (this.squares)
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
        
        this.squares = new ArrayList <Set<Integer>>();

        for(int count = 0; count<9; count+=3){
            
                for(int j = 0; j<9; j+=3){
                    Set<Integer> currsq = new HashSet<>();
                    for(int k =count; k<count+3;k++){
                        for(int l = j; l<j+3;l++){
                            currsq.add(grid[k][l]);
                        }
                    }
                    this.squares.add(currsq);
                }
        }

       

       //System.out.println(squares);
        


        // create a hash set for [1..9] (this.nums)
        this.nums = new HashSet<>();
        for (int k = 1; k <= N; k++) {
            nums.add(k);
        }

        
        

        // visually inspect that all the sets are correct
        for (int row = 0; row < N; row++) {
            System.out.println("row " + row + ": " + this.rows.get(row));
        }
        for (int col = 0; col < N; col++) {
            System.out.println("col " + col + ": " + this.cols.get(col));
        }
        for (int square = 0; square < N; square++) {
            System.out.println("square " + square + ": " + this.squares.get(square));
        }
        System.out.println(this.nums);
    }

    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int rownext = -1;
        int colNext = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    rownext = row;
                    colNext = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to rownext, colNext, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */
        Set<Integer> possibleNumbers = new HashSet<Integer>();
        possibleNumbers.add(this.nums);
        
        Set<Integer> rowNums = rows.get(rownext);
        for(int n:rowNums){
            possibleNumbers.remove(n);
        }

        Set<Integer> colNums = cols.get(colNext);
        for(int n:colNums){
            possibleNumbers.remove(n);
        }

        int rSquare = rownext/3;

        int cSquare =colNext/3;

        int square = rSquare * 3 + cSquare;

        Set<Integer> sqNums;

        if(rownext<3){
            if(colNext<3){
                sqNums = squares.get(0);
            }
            else if(colNext<6){
                sqNums =squares.get(1);}
            else{
                sqNums =squares.get(2);
            }
            }
        else if(rownext<6){
            if(colNext<3){
                sqNums = squares.get(3);
            }
            else if(colNext<6){
                sqNums =squares.get(4);}
            else{
                sqNums =squares.get(5);
            }
            }
        else{
            if(colNext<3){
                sqNums = squares.get(6);
            }
            else if(colNext<6){
                sqNums =squares.get(7);}
            else{
                sqNums =squares.get(8);
            }
            }

        for(int n: sqNums){
            possibleNumbers.remove(n);
        }
        
            System.out.println(possibleNumbers);

        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNumbers.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNumbers) {

            // update the grid and all three corresponding sets with possibleNum

            this.grid[rownext][colNext] = possibleNum;

            
            rows.get(rownext).add(possibleNum);

            cols.get(colNext).add(possibleNum);

            squares.get(square).add(possibleNum);

            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
            } else {
                /*
                 Undo the move before trying another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
                this.grid[rownext][colNext]=0;

                rows.get(rownext).remove(possibleNum);

                cols.get(colNext).remove(possibleNum);

                squares.get(square).remove(possibleNum);
            }
        }

        return false;
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "Chapter 15 Activities/Sudoku/src/puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }

       
}
