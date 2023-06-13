import java.util.Random;

public class Field {

    public static final int size = 20;
    public static final int startR = 3;
    public static final int startW = 5;
    public static final double moveR = 1.0 / 9;
    public static final double birthR = 1.0 / 5;
    public static final double birthW = 1.0 / 100;

    public static final char empty = '_';
    public static final char rabbit = 'R';
    public static final char wolf = 'W';

    public static char[][] pole = new char[size][size];
    public static Random r = new Random();

    protected void emptypole() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                pole[i][j] = empty;
            }
        }
    }

    protected void startspawn(int count, char race) {
        int needed_count = 0;
        while (needed_count < count) {
            int x = r.nextInt(size);
            int y = r.nextInt(size);
            if (pole[x][y] == empty) {
                pole[x][y] = race;
                needed_count++;
            }
        }
    }


    protected void iteration() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char race = pole[i][j];
                if (race == rabbit) {
                    Animal rabbit = new Rabbit(i, j);
                    rabbit.move();
                    rabbit.birth();
                } else if (race == wolf) {
                    Animal wolf = new Wolf(i, j);
                    wolf.move();
                    wolf.birth();
                }
            }
        }
    }

    protected void printField() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(pole[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
