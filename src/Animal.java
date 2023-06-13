public abstract class Animal{
    protected int x;
    protected int y;


    protected Animal(int x, int y) {
        this.x = x;
        this.y = y;
    }


    protected abstract void move();

    protected abstract void birth();

    protected boolean approachCell(int x, int y) {
        return x >= 0 && x < Field.size && y >= 0 && y < Field.size;
    }
}