package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
 
class Board {
    public char[][] board = new char[9][9];
 
    Board() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = ' ';
            }
        }
    }
 
    public List<Integer> getPossibilities(int x, int y){
        boolean[] visited = new boolean[256];
 
        for(int i = 0; i < 9; i++){
            visited[board[i][y]] = true;
            visited[board[x][i]] = true;
            visited[board[x/3*3 + i/3][y/3*3 + i%3]] = true;
        }
 
        List<Integer> v = new ArrayList<>();
        for(char c = '1'; c <= '9'; c++){
            if(!visited[c]){
                v.add(c - '0');
            }
        }
        return v;
    }
 
    // Override equals to compare boards
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Board other = (Board) obj;
        return Arrays.deepEquals(this.board, other.board);
    }
 
    // Override hashCode to generate a hash based on the board's contents
    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }
 
    @Override
    public String toString() {
        String result = "";
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                result += board[j][i] + (i == board[j].length - 1 ? "\n" : "|");
            }
            if(j != 8){
                result += "-+-+-+-+-+-+-+-+-\n";
            }
        }
        return result;
    }
 
}
class AI_Agent {
    public boolean solve(Board board, int start){
        if(start == 81){
            return true;
        }
        int x = start / 9;
        int y = start % 9;
 
        if(board.board[x][y] != 0){
            return solve(board, start + 1);
        }
 
        for(int guess : board.getPossibilities(x, y)){
            board.board[x][y] = (char)(guess + '0');
            if(solve(board, start + 1)){
                return true;
            }
            board.board[x][y] = ' ';
        }
        return false;
    }
}
public class Game {    
    public static void main(String[] args) throws FileNotFoundException{
        File fin = new File("sudoku/0.in");
        Scanner sc = new Scanner(fin);
        Board b = new Board();
        for (int i=0; i<9; i++) {
            String s = sc.nextLine();
            for (int j=0; j<9; j++) {
                b.board[i][j] = s.charAt(j);
            }
        }
        AI_Agent ai_Agent = new AI_Agent();
        ai_Agent.solve(b, 0);
        System.out.println("===");
        System.out.println(b);
        /* 
        System.out.println(b);
        while(!b.isEnd()){
            String position = sc.nextLine();
            while (!b.changeBoard(position)) {
                System.out.println("Error, type again: ");
                position = sc.nextLine();
            }
            System.out.println(b);
        }
        if (b.getWinner() == ' ')
            System.out.println("Tie");
        else
            System.out.println("Winner: " + b.getWinner());
        */
    }
}