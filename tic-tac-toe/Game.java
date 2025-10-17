import java.util.Arrays;
import java.util.Scanner;
import java.util.Enumeration;
import java.util.Hashtable;

class Board {
    public char[][] board = new char[3][3];
    public final char PLAYER_1 = 'O';
    public final char PLAYER_2 = 'X';
    public char current;
    Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        current = PLAYER_1;
    }
    public boolean isEnd() {
        // board full || sb win
        if(getWinner() != ' ' || isFull()){
            return true;
        } else {
            return false;
        }
    }
    public boolean changeBoard(String pos) {
        // success: true
        int row = pos.charAt(0) - '0';
        int col = pos.charAt(1) - '0';

        if(row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] ==  ' '){
            board[row][col] = current;
            if (current == PLAYER_1)
                current = PLAYER_2;
            else
                current = PLAYER_1;
            return true;
        } else {
            return false;
        }
    }

    public char getWinner() {
        if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][2] == board[0][0]){
            return board[0][0];
        }else if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][2] == board[1][0]){
            return board[1][0];
        }else if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][2] == board[2][0]){
            return board[2][0];
        }else if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] == board[0][0]){
            return board[0][0];
        }else if(board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[2][1] == board[0][1]){
            return board[0][1];
        }else if(board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[2][2] == board[0][2]){
            return board[0][2];
        }else if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == board[0][0]){
            return board[0][0];
        }else if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == board[0][2]){
            return board[0][2];
        }else{
            return ' ';
        }
    }

    public boolean isFull(){
        boolean x = true;
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                if(board[i][j] == ' '){
                    x = false;
                }
            }
        }
        return x;
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
        for (int j = 0; j < board.length; j++) {
            if (j != 2) {
                for (int i = 0; i < board[j].length; i++) {
                    result += board[j][i] + (i == board[j].length - 1 ? "\n" : "|");
                }
                result += "-+-+-\n";
            } else {
                for (int i = 0; i < board[j].length; i++) {
                    result += board[j][i] + (i == board[j].length - 1 ? "\n" : "|");
                }
            }
        }
        return result;
    }

}
class AI_Agent {
    private Hashtable<Board, String> hashTable = new Hashtable<>();
    public String recursion(Board cur) {
        System.out.println(cur);
        if (cur.isEnd()) {
            return cur.getWinner() + "";
        }
        if (hashTable.containsKey(cur)) {
            return hashTable.get(cur);
        }
        String []allPos = {"00","01","02","10","11","12","20","21","22"};
        boolean canTie = false;
        for (String pos : allPos) {
            Board nxt = new Board();
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    nxt.board[i][j] = cur.board[i][j];
                }
            }
            nxt.current = cur.current;
            if (nxt.changeBoard(pos)) {
                String result = recursion(nxt);
                if (cur.current == result.charAt(0)) {
                    hashTable.put(cur, result);
                    return cur.current + pos;
                } else if (result.charAt(0) == ' ') {
                    canTie = true;
                }
            }
            // cur.printBoard();
        }
        if (canTie) {
            hashTable.put(cur, " ");
            return " ";
        } else {
            char result = cur.current == cur.PLAYER_1 ? cur.PLAYER_2 : cur.PLAYER_1;
            hashTable.put(cur, result + "");
            return result + "";
        }
    }
}
public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board b = new Board();
        b.board[2][2] = b.board[2][1] = 'X';
        b.board[0][0] = b.board[1][1] = 'O';

        AI_Agent ai_Agent = new AI_Agent();
        System.out.println("Winner: " + ai_Agent.recursion(b));
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
