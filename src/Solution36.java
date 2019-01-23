import java.util.HashSet;
import java.util.Set;

class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> a = new HashSet<>();
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int number = 0;
                for (int h = 0; h < 3; h++) {
                    for (int w = 0; w < 3; w++) {
                        if (board[i + h][j + w] == '.') {

                        } else {
                            a.add(new Character(board[i + h][j + w]));
                            number++;
                        }

                    }
                }
                if (a.size() != number) return false;
                a.removeAll(a);
            }
        }
        for (int i = 0; i < 9; i++) {
            int number = 0;
            for (int j = 0; j < 9; i++) {
                if (board[i][j] == '.') {

                } else {
                    a.add(new Character(board[i][j]));
                    number++;
                }
            }
            if (a.size() != number) return false;
            a.removeAll(a);
        }
        for (int j = 0; j < 9; j++) {
            int number = 0;
            for (int i = 0; i < 9; j++) {
                if (board[i][j] == '.') {

                } else {
                    a.add(new Character(board[i][j]));
                    number++;
                }
            }
            if (a.size() != number) return false;
            a.removeAll(a);
        }
        return true;
    }
}