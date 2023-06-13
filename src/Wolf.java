public class Wolf extends Animal {
    private double hunger;

    protected Wolf(int x, int y) {
        super(x, y);
        this.hunger = 1.0;
    }

    @Override
    protected void move() {
        int newX = x + Field.r.nextInt(3) - 1;
        int newY = y + Field.r.nextInt(3) - 1;

        while (!approachCell(newX, newY))
        {
            newX = x + Field.r.nextInt(3) - 1;
            newY = y + Field.r.nextInt(3) - 1;
        }

        if (Field.pole[newX][newY] == Field.rabbit) {
            Field.pole[newX][newY] = Field.wolf;
            Field.pole[x][y] = Field.empty;
            x = newX;
            y = newY;
            hunger = 1.0;
        } else if (Field.pole[newX][newY] == Field.empty) {
            Field.pole[newX][newY] = Field.wolf;
            Field.pole[x][y] = Field.empty;
            x = newX;
            y = newY;

            hunger -= 0.1;
            if (hunger <= 0) {
                Field.pole[x][y] = Field.empty;
            }
        }
    }

    @Override
    protected void birth() {
        if (Field.r.nextDouble() < Field.birthW) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newX = x + i;
                    int newY = y + j;
                    if (approachCell(newX, newY) && Field.pole[newX][newY] == Field.empty) {
                        Field.pole[newX][newY] = Field.wolf;
                        return;
                    }
                }
            }
        }
    }
}