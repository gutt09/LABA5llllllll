import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Field pole = new Field();
        pole.emptypole();
        pole.startspawn(Field.startR, Field.rabbit);
        pole.startspawn(Field.startW, Field.wolf);
        int countIterations = vvod();
        for(int i=0; i<countIterations;i++)
        {
            pole.iteration();
            pole.printField();
        }

    }


    public static int vvod()
    {
        System.out.print("Введите количество итераций -> ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}