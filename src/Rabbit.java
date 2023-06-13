public class Rabbit extends Animal {
    protected Rabbit(int x, int y) {

        super(x, y);
    }

    @Override
    protected void move() {
        int newX = x + Field.r.nextInt(3) - 1; // от -1 до 1
        int newY = y + Field.r.nextInt(3) - 1;
        if (approachCell(newX, newY) && Field.pole[newX][newY] == Field.empty) {
            if (Field.r.nextDouble() < Field.moveR) {
                Field.pole[newX][newY] = Field.rabbit;
                Field.pole[x][y] = Field.empty;
                x = newX;
                y = newY;
            }
        }
    }

    @Override
    protected void birth() {
        if (Field.r.nextDouble() < Field.birthR) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newX = x + i;
                    int newY = y + j;
                    if (approachCell(newX, newY) && Field.pole[newX][newY] == Field.empty) {
                        Field.pole[newX][newY] = Field.rabbit;
                        return;
                    }
                }
            }
        }
    }
}