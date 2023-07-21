package First_Interview.fifth_interview;

public class Solutioin1 {
    public static boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;
            } else if (move == 'L') {
                x--;
            } else if (move == 'R') {
                x++;
            }
        }

        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        String moves = "UD";
        boolean returnsToOrigin = judgeCircle(moves);
        System.out.println(returnsToOrigin);
    }
}

