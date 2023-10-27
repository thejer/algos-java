package javaSolutions.src.old.initialPractice;

public class FrogJump {

    private static int solution(int X, int Y, int D) {
        int distance = Y - X;
        if (distance == 0) return 0;
        if (D >= distance) return 1;
        int count = Math.floorDiv(distance, D);
        int mod = distance % D;
        if (mod > 0) {
            count += 1;
        }
        if (X == Y) return 0;

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
    }
}
