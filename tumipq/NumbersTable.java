package javaSolutions.tumipq;

public class NumbersTable {

    public static int square(int number) {
        return (int) Math.pow(number, 2);
    }

    public static double squareRoot(int number) {
        return Math.sqrt(number);
    }

    public static int cube(int number) {
        return (int) Math.pow(number, 3);
    }

    public static double cubeRoot(int number) {
        return Math.cbrt(number);
    }

    public static void main(String[] args) {

        String [] headers = new String[] {"N", "Nsq", "NSqRoot", "NCube", "NCubeRoot"};
        for (String header :
             headers) {
            System.out.print(header + "     ");
        }
        System.out.println();

        for (int i = 1; i <= 5 ; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(getCalculation(i, j) + "       ");
            }
            System.out.println();
        }
    }

    static String getCalculation(int i, int j) {
        switch (j) {
            case 2: {
                return String.valueOf(square(i));
            }
            case 3: {
                return String.format("%.2f", squareRoot(i));
            }
            case 4: {
                return String.valueOf(cube(i));
            }
            case 5: {
                return String.format("%.2f", cubeRoot(i));
            }
            default: {
                return String.valueOf(i);
            }
        }

    }
}
